package com.mylearn.springcloud.orderservice.service;

import com.mylearn.springcloud.orderservice.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<Long, User> map = new HashMap<>();

    public User getUser(Long userId){
        return map.get(userId);
    }

    @PostConstruct
    public void init(){
        map.put(1L,new User(1L,"1aa","北京"));
        map.put(2L,new User(2L,"1BB","南京"));
        map.put(3L,new User(3L,"1cc","东京"));
    }

}
