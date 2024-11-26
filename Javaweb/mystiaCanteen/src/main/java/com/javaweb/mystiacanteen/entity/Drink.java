package com.javaweb.mystiacanteen.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;


@Data
public class Drink extends Production{
    private Integer id;//ID
    private String name;//饮品名
    private String description;//饮品描述
    private Integer price;//饮品价格
    private String image;//饮品图片
    private JsonNode tags;//饮品标签
    private String position;//图片位置
}
