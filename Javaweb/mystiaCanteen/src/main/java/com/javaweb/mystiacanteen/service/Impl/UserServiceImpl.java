package com.javaweb.mystiacanteen.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.mystiacanteen.entity.User;
import com.javaweb.mystiacanteen.mapper.UserMapper;
import com.javaweb.mystiacanteen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String getPassword(String username) {
        return userMapper.getPassword(username);
    }

    @Override
    public Boolean addUser(String username, String password, String name, String gender, String email){
        return userMapper.addUser(username, password, name, gender, email);
    }
}
