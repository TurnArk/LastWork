package com.javaweb.mystiacanteen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaweb.mystiacanteen.entity.Drink;

import java.util.List;

public interface DrinkService extends IService<Drink> {
    public List<Drink> getAllDrink();
    public List<Drink> getDrinkByName(String name);
}
