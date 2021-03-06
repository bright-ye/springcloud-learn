package com.mylearn.springcloud.orderservice.service;

import com.mylearn.springcloud.orderservice.pojo.Order;
import com.mylearn.springcloud.orderservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    Map<Long, Order> map = new HashMap<>();

    public Order queryOrderById(Long orderId) {
        Order order = map.get(orderId);
        String url = "http://userservice/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return map.get(orderId);
    }

    @PostConstruct
    public void init() {
        map.put(1L, new Order(1L,2L,"aa",1,1L,null));
        map.put(2L, new Order(2L,3L,"BB",2,2L,null));
        map.put(3L, new Order(3L,4L,"cc",3,3L,null));
    }

}
