package com.javaweb.mystiacanteen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.mystiacanteen.entity.Dish;
import com.javaweb.mystiacanteen.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {
    @Select("SELECT * FROM food")
    List<Food> getAllFood();

    @Select("SELECT * FROM food WHERE name LIKE CONCAT('%',#{name},'%')")
    List<Food> getFoodByName(String name);

    @Select("SELECT * FROM food WHERE name = #{name}")
    Dish selectFoodByName(String name);
}
