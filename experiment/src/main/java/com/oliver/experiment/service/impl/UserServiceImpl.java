package com.oliver.experiment.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oliver.experiment.domain.User;
import com.oliver.experiment.mapper.UserMapper;
import com.oliver.experiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oliver
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public List<User> getUserList() {
        return userMapper.selectList(null);
    }
}
