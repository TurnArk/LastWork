package com.javaweb.mystiacanteen.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;


@Data
public class Dish extends Production{
    private Integer id;//ID
    private String name;//菜名
    private String description;//菜的描述
    private Integer price;//菜价
    private String image;//菜品图片
    private JsonNode tags;//菜品标签
    private String position;//图片位置
}
