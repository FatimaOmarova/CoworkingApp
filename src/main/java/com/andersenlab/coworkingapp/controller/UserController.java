package com.andersenlab.coworkingapp.controller;

import com.andersenlab.coworkingapp.service.UserService;
import com.andersenlab.coworkingapp.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("save/user")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
    @GetMapping("view/user")
    public List<User> viewUser(){
        return userService.viewUser();
    }
}
