package com.javaweb.mystiacanteen.entity;

import lombok.Data;

import java.util.List;

@Data
public class Drink {
    private Integer id;//ID
    private String name;//饮品名
    private String description;//饮品描述
    private Integer price;//饮品价格
    private String image;//饮品图片
    private List<String> tags;//饮品标签
}
