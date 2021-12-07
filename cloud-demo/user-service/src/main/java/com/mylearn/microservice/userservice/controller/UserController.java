package com.mylearn.microservice.userservice.controller;

import com.mylearn.microservice.userservice.config.PatternProperties;
import com.mylearn.microservice.userservice.pojo.User;
import com.mylearn.microservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${pattern.dateformat}")
    private String dateformat;

    @Autowired
    private HttpServletResponse httpServletResponse;


    @Autowired
    private PatternProperties patternProperties;

    @GetMapping("{userId}")
    public User getUser(@PathVariable("userId")Long userId){
        User user = userService.getUser(userId);
        return user;
    }

    @GetMapping("now")
    public void now() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat)));
        stringBuilder.append("\n");
        stringBuilder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat())));
        httpServletResponse.getWriter().println(stringBuilder.toString());
    }

    @GetMapping("prop")
    public PatternProperties prop(){
        return patternProperties;
    }

}
