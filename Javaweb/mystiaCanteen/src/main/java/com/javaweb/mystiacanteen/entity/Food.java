package com.javaweb.mystiacanteen.entity;

import lombok.Data;

import java.util.List;

@Data
public class Food {
    private Integer id;//ID
    private String name;//食材名
    private String description;//食材描述
    private Integer price;//食材价格
    private String image;//食材图片
    private List<String> tags;//食材标签
}
