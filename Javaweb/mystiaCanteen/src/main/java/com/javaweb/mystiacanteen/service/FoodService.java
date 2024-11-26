package com.javaweb.mystiacanteen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaweb.mystiacanteen.entity.Food;

import java.util.List;

public interface FoodService extends IService<Food> {
    public List<Food> getAllFood();
    public List<Food> getFoodByFoodName(String foodName);
}
