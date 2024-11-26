package com.javaweb.mystiacanteen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaweb.mystiacanteen.entity.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {
    public List<Dish> getDishByName(String name);
    public List<Dish> getAllDish();
}
