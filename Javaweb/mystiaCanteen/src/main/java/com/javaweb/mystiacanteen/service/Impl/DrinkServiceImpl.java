package com.javaweb.mystiacanteen.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.mystiacanteen.entity.Drink;
import com.javaweb.mystiacanteen.mapper.DrinkMapper;
import com.javaweb.mystiacanteen.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl extends ServiceImpl<DrinkMapper, Drink> implements DrinkService {
    @Autowired
    private DrinkMapper drinkMapper;

    @Override
    public List<Drink> getAllDrink(){
        return drinkMapper.getAllDrink();
    }

    @Override
    public List<Drink> getDrinkByName(String drinkName){
        return drinkMapper.getDrinkByName(drinkName);
    }
}
