package com.javaweb.mystiacanteen.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.mystiacanteen.entity.Drink;
import com.javaweb.mystiacanteen.mapper.DrinkMapper;
import com.javaweb.mystiacanteen.service.DrinkService;
import org.springframework.stereotype.Service;

@Service
public class DrinkServiceImpl extends ServiceImpl<DrinkMapper, Drink> implements DrinkService {
}
