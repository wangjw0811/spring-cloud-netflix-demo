### 1 
    如果hystrix.command.default.execution.timeout.enabled为true 
     则会有两个执行方法超时的配置,一个就是ribbon的ReadTimeout,
     一个就是熔断器hystrix的timeoutInMilliseconds, 此时谁的值小谁生效
### 2 
    如果hystrix.command.default.execution.timeout.enabled为false,
    则熔断器不进行超时熔断,而是根据ribbon的ReadTimeout抛出的异常而熔断,也就是取决于ribbon
### 3 
    ribbon的ConnectTimeout,配置的是请求服务的超时时间,除非服务找不到,或者网络原因,
    这个时间才会生效
### 4 
    ribbon还有MaxAutoRetries对当前实例的重试次数,
    MaxAutoRetriesNextServer对切换实例的重试次数, 如果ribbon的ReadTimeout超时,
    或者ConnectTimeout连接超时,会进行重试操作
### 5 
    由于ribbon的重试机制,通常熔断的超时时间需要配置的比ReadTimeout长,
    ReadTimeout比ConnectTimeout长,否则还未重试,就熔断了
## 6 
    为了确保重试机制的正常运作,理论上（以实际情况为准）建议
    hystrix的超时时间为:(1 + MaxAutoRetries + MaxAutoRetriesNextServer) * ReadTimeout

### feign集成hystrix需要配置开启
 feign.hystrix.enabled=true
### hystrix的超时时间 熔断超时时间必须大于服务器业务处理时间，否则熔断没有实际意义，熔断时间大于ribbon超时时间，否则重试没有实际意义
### hystrix.command.default.execution.timeout.enabled=true
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=9000
### ribbon的超时时间 服务器业务处理时间必须大于以下时间才能发起重试
### 负载均衡超时时间，默认值5000
ribbon.ReadTimeout=3000
### ribbon请求连接的超时时间，默认值2000
ribbon.ConnectTimeout=3000
### 同一台实例最大重试次数,不包括首次调用,默认0
ribbon.MaxAutoRetries=0
### 重试负载均衡其他的实例最大重试次数,不包括首次调用,默认1
ribbon.MaxAutoRetriesNextServer=0
### 是否所有操作都重试
ribbon.OkToRetryOnAllOperations=false