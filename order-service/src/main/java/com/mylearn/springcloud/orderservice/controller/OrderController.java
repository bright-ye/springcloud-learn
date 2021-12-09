package com.mylearn.springcloud.orderservice.controller;

import com.mylearn.springcloud.orderservice.pojo.Order;
import com.mylearn.springcloud.orderservice.pojo.User;
import com.mylearn.springcloud.orderservice.service.OrderService;
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

    @GetMapping("{orderId}")
    public Order getOrder(@PathVariable("orderId") Long orderId) {
        Order order = orderService.queryOrderById(orderId);
        return order;
    }
}
