package com.mylearn.microservice.orderservice.controller;


import com.mylearn.microservice.clients.UserClient;
import com.mylearn.microservice.orderservice.pojo.Order;
import com.mylearn.microservice.orderservice.service.OrderService;
import com.mylearn.microservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserClient userClient;

    @GetMapping("{orderId}")
    public Order getOrder(@PathVariable("orderId") Long orderId) {
        Order order = orderService.queryOrderById(orderId);
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        return order;
    }

}
