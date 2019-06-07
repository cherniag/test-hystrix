package com.example.demo.controller;

import java.util.Random;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private Random random = new Random();
    @Value("${user.service.error.probability}")
    private double errorProbability;
    @Value("${user.service.timeout.probability}")
    private double timeoutProbability;
    @Value("${user.service.timeout.value}")
    private long timeoutValue;

    @GetMapping(path = "/user", produces = APPLICATION_JSON_UTF8_VALUE)
    public User getUser() {
        checkProbability();
        return new User(System.currentTimeMillis());
    }

    private void checkProbability() {
        double nextDouble = random.nextDouble();

        if (timeoutProbability >= nextDouble) {
            logger.error("Timeout {}, probability {}", nextDouble, timeoutProbability);
            try {
                Thread.sleep(timeoutValue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        nextDouble = random.nextDouble();
        if (errorProbability >= nextDouble) {
            throw new RuntimeException("Error probability: " + errorProbability + ", next: " + nextDouble);
        }
    }
}
