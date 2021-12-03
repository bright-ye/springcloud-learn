package com.mylearn.microservice.userservice.controller;

import com.mylearn.microservice.userservice.pojo.User;
import com.mylearn.microservice.userservice.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private static Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("{userId}")
    public User getUser(@PathVariable("userId")Long userId){
        log.info("query userid: "+ String.valueOf(userId));
        User user = userService.getUser(userId);
        return user;
    }

}
