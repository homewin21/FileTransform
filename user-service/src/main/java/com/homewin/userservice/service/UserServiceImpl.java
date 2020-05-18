package com.homewin.userservice.service;

import com.homewin.userservice.dao.UserDao;
import com.homewin.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    /**
     * 查询验证码是否存在
     *
     * @param key key
     * @return valCode if exists
     */
    @Override
    public String getValCode(String key) {
        return userDao.getValCode(key);
    }

    /**
     * 设置6位数随机验证码
     *
     * @param key key 请求的ip组成
     * @return boolean
     */
    @Override
    public Boolean setValCode(String key) {
        String value = "" + (int) Math.random() * 100000;
        return userDao.setValCode(key, value);
    }


}
