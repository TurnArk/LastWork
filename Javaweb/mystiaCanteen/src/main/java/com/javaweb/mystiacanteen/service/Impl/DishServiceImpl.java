package com.javaweb.mystiacanteen.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.mystiacanteen.entity.Dish;
import com.javaweb.mystiacanteen.mapper.DishMapper;
import com.javaweb.mystiacanteen.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired DishMapper dishMapper;

    @Override
    public List<Dish> getAllDish(){
        return dishMapper.getAllDish();
    }

    @Override
    public List<Dish> getDishByName(String dishName){
        return dishMapper.getDishByName(dishName);
    }
}
