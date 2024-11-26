package com.javaweb.mystiacanteen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javaweb.mystiacanteen.entity.Kitchenware;

import java.util.List;

public interface KitchenwareService extends IService<Kitchenware> {
    public List<Kitchenware> getAllKitchenware();
    public List<Kitchenware> getKitchenwareByName(String name);
}
