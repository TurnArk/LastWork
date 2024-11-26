package com.javaweb.mystiacanteen.entity;

import lombok.Data;

@Data
public class Kitchenware extends Production{
    private Integer id;//ID
    private String name;//厨具名
    private String description;//厨具描述
    private Integer price;//厨具价格
    private String image;//厨具图片
    private String position;//图片位置
}
