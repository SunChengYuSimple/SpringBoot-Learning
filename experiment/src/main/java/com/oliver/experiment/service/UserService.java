package com.oliver.experiment.service;

import com.oliver.experiment.domain.User;

import java.util.List;

/**
 * @author Oliver
 */
public interface UserService {
    
    /**
     * 处理"/users/"的GET请求，用来获取用户列表
     *
     * @return 所有用户
     */
    List<User> getUserList();
}
