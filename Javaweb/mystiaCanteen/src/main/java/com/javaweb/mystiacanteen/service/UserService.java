package com.javaweb.mystiacanteen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaweb.mystiacanteen.entity.User;

public interface UserService extends IService<User> {
    public String getPassword(String username);
    public Boolean addUser(String username, String password, String name, String gender, String email);
}
