package com.mylearn.springcloud.orderservice.controller;

import com.mylearn.springcloud.orderservice.pojo.User;
import com.mylearn.springcloud.orderservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{userid}")
    public User getUser(@PathVariable("userid")long userid){
        return userService.getUser(userid);
    }

}
