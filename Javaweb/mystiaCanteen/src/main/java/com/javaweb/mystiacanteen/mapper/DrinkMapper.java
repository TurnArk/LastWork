package com.javaweb.mystiacanteen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.mystiacanteen.entity.Drink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DrinkMapper extends BaseMapper<Drink> {
    @Select("SELECT * FROM drink")
    List<Drink> getAllDrink();

    @Select("SELECT * FROM drink WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Drink> getDrinkByName(String name);

    @Select("SELECT * FROM drink WHERE name = #{name}")
    Drink selectDrinkByName(String name);//专供购物车功能用的
}
