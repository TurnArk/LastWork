package com.javaweb.mystiacanteen.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.mystiacanteen.entity.Food;
import com.javaweb.mystiacanteen.mapper.FoodMapper;
import com.javaweb.mystiacanteen.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> getAllFood(){
        return foodMapper.getAllFood();
    }

    @Override
    public List<Food> getFoodByFoodName(String foodName){
        return foodMapper.getFoodByName(foodName);
    }
}
