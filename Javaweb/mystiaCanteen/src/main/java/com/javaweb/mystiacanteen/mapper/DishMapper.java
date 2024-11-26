package com.javaweb.mystiacanteen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.mystiacanteen.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
    @Select("SELECT * FROM dish")
    List<Dish> getAllDish();

    @Select("SELECT * FROM dish WHERE name LIKE CONCAT('%', #{name}, '%') ")
    List<Dish> getDishByName(String name);

    @Select("SELECT * FROM dish WHERE name = #{name}")
    Dish selectDishByName(String name);
}
