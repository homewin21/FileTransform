package com.homewin.userservice.dao;

import com.homewin.userservice.domain.User;
import com.homewin.userservice.util.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author homewin
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoUtils mongoUtils;

    /**
     * 手机号是否已经被注册
     *
     * @param telephone 手机号
     * @return boolean true:已注册 false:未注册
     */
    @Override
    public boolean existsUser(String telephone) {
        return mongoUtils.existsUser(telephone);
    }

    /**
     * 注册新用户
     *
     * @param user userinfo
     * @return boolean
     */
    @Override
    public boolean register(User user) {
        return mongoUtils.updateUser(user);
    }

    /**
     * 根据手机号查找对应用户信息
     *
     * @param telephone telephone
     * @return user
     */
    @Override
    public User findUser(String telephone) {
        return mongoUtils.findUser(telephone).get(0);
    }

    /**
     * 更新用户信息
     *
     * @param newUser new userinfo
     * @return boolean
     */
    @Override
    public boolean updateUser(User newUser) {
        return mongoUtils.updateUser(newUser);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean setValCode(String key, String value) {
        return false;
    }


}
