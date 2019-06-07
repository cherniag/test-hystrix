package com.example.demo.controller;

import com.example.demo.integration.user.User;
import com.example.demo.integration.user.UserClient;
import com.example.demo.model.FullUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacadeController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/fullUser")
    public FullUser getFullUser() {
        User user = userClient.getUser();
        return new FullUser(user.getId(), user.getId() != 0L);
    }
}
