package com.mylearn.microservice.orderservice.controller;

import com.mylearn.microservice.orderservice.pojo.Order;
import com.mylearn.microservice.orderservice.pojo.User;
import com.mylearn.microservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{orderId}")
    public Order getOrder(@PathVariable("orderId") Long orderId) {
        Order order = orderService.queryOrderById(orderId);
        String url = "http://userservice/user/" + orderId;
        User user = restTemplate.getForObject(url,User.class);
        order.setUser(user);
        return order;
    }

}
