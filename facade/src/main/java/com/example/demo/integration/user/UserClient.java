package com.example.demo.integration.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(name = "user-service", url = "${integration.user.service.url}", fallbackFactory = UserClientFallBackFactory.class)
public interface UserClient {

    @GetMapping(path = "/user", consumes = APPLICATION_JSON_UTF8_VALUE)
    User getUser();
}
