package com.blog.service.impl;

import com.blog.exception.GDException;
import com.blog.mapper.ShopMapper;
import com.blog.model.Shop;
import com.blog.service.interf.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GD on 2018/3/13.
 */
@Service
@Transactional
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Shop getShopById(Integer id) {
        if(id == null || id.intValue()<=0){
            throw new GDException("id is error");
        }
        return shopMapper.selectByPrimaryKey(id);
    }
}
