package com.mylearn.microservice.orderservice.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String address;
}
