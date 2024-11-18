package com.javaweb.mystiacanteen.entity;

import lombok.Data;

import java.util.List;

@Data
public class Dish {
    private Integer id;//ID
    private String name;//菜名
    private String description;//菜的描述
    private Integer price;//菜价
    private String image;//菜品图片
    private List<String> tags;//菜品标签
}
