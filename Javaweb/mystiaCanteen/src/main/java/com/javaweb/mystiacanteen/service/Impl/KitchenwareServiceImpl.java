package com.javaweb.mystiacanteen.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.mystiacanteen.entity.Kitchenware;
import com.javaweb.mystiacanteen.mapper.KitchenwareMapper;
import com.javaweb.mystiacanteen.service.KitchenwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitchenwareServiceImpl extends ServiceImpl<KitchenwareMapper, Kitchenware> implements KitchenwareService {
    @Autowired
    private KitchenwareMapper kitchenwareMapper;

    @Override
    public List<Kitchenware> getAllKitchenware() {
        return kitchenwareMapper.getAllKitchenware();
    }

    @Override
    public List<Kitchenware> getKitchenwareByName(String name) {
        return kitchenwareMapper.getKitchenwareByName(name);
    }
}
