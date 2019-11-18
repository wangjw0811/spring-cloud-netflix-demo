package com.example.web.config;

import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;

@Configuration
public class FeignRetryConfig {

    @Bean
    public Retryer retryer(){
        return new Retryer.Default();
    }

    // 重试回退策略
    @Bean
    LoadBalancedRetryFactory retryFactory() {
        return new LoadBalancedRetryFactory() {
            @Override
            public BackOffPolicy createBackOffPolicy(String service) {
                return new ExponentialBackOffPolicy();
            }
        };
    }

}
