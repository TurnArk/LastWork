package com.javaweb.mystiacanteen.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;


@Data
public class Food extends Production{
    private Integer id;//ID
    private String name;//食材名
    private String description;//食材描述
    private Integer price;//食材价格
    private String image;//食材图片
    private JsonNode tags;//食材标签
    private String position;//图片位置
}
