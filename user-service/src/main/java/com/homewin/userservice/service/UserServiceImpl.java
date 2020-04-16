package com.homewin.userservice.service;

import com.homewin.userservice.dao.UserDao;
import com.homewin.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author homewin
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 手机号是否已经被注册
     *
     * @param telephone 手机号
     * @return boolean true:已注册 false:未注册
     */
    @Override
    public boolean existsUser(String telephone) {
        return userDao.existsUser(telephone);
    }

    /**
     * 注册新用户
     *
     * @param user userinfo
     * @return boolean
     */
    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }

    /**
     * 根据电话号码查找用户信息
     *
     * @param telephone telephone
     * @return user
     */
    @Override
    public User findUser(String telephone) {
        return userDao.findUser(telephone);
    }


}
