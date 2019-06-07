package com.example.demo.integration.user;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallBackFactory implements FallbackFactory<UserClient> {
    private static final Logger logger = LoggerFactory.getLogger(UserClientFallBackFactory.class);

    @Override
    public UserClient create(Throwable throwable) {
        logger.error("Error on get user: {} - {}", throwable.getClass().getSimpleName(), throwable.getMessage());
        return User::new;
    }
}
