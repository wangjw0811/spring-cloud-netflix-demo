package com.example.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFallBackFactory implements FallbackFactory<UserApi> {
    @Override
    public UserApi create(Throwable throwable) {
        return null;
    }
}
