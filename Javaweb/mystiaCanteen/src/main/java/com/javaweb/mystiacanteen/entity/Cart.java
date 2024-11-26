package com.javaweb.mystiacanteen.entity;

import lombok.Data;

@Data
public class Cart {
    private Integer cartId;
    private String username;
    private String name;
    private Integer num;
}
