package com.homewin.userservice.dao;

import com.homewin.userservice.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author homewin
 */
@Repository
public interface UserDao {
    /**
     * 手机号是否已经被注册
     *
     * @param telephone 手机号
     * @return boolean true:已注册 false:未注册
     */
    boolean existsUser(String telephone);

    /**
     * 注册新用户
     *
     * @param user userinfo
     * @return boolean
     */
    boolean register(User user);

    /**
     * 根据手机号查找对应用户信息
     *
     * @param telephone telephone
     * @return user
     */
    User findUser(String telephone);


    /**
     * 更新用户信息
     *
     * @param newUser new userinfo
     * @return boolean
     */
    boolean updateUser(User newUser);

    /**
     * 添加valCode
     * @param key key
     * @param value value
     * @return boolean
     */
    boolean setValCode(String key, String value);

    /**
     * 获取valCode
     *
     * @param key key
     * @return value or null
     */
    String getValCode(String key);
}
