package com.blog.service.impl;

import com.blog.mapper.UserMapper;
import com.blog.model.User;
import com.blog.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GD on 2017/9/2.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginUser(int id) throws Exception {
        return userMapper.selectByPrimaryKey(id);
    }
}
