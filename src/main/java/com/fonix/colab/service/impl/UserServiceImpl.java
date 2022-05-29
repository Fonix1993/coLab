package com.fonix.colab.service.impl;

import com.fonix.colab.entity.User;
import com.fonix.colab.mapper.UserMapper;
import com.fonix.colab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Fonix
 * @since 2022-05-15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public User getById(Long valueOf) {
        return userMapper.getById(valueOf);
    }

    @Override
    public Integer create(User user) {
        return userMapper.create(user);
    }
}
