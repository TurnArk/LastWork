package com.javaweb.mystiacanteen.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaweb.mystiacanteen.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT password FROM user WHERE username=#{username}")
    String getPassword(String username);//登录用

    @Insert("INSERT INTO user VALUES (#{username},#{password},#{name},#{gender},#{email},0)")
    Boolean addUser(String username, String password, String name, String gender, String email);//注册用户
}
