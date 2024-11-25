package com.javaweb.mystiacanteen.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaweb.mystiacanteen.entity.Kitchenware;
import com.javaweb.mystiacanteen.mapper.KitchenwareMapper;
import com.javaweb.mystiacanteen.service.KitchenwareService;
import org.springframework.stereotype.Service;

@Service
public class KitchenwareServiceImpl extends ServiceImpl<KitchenwareMapper, Kitchenware> implements KitchenwareService {
}
