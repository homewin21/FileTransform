package com.homewin.userservice.service;


import com.homewin.userservice.domain.User;

/**
 * @author homewin
 */
public interface UserService {
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
     * 根据电话号码查找用户信息
     *
     * @param telephone telephone
     * @return user
     */
    User findUser(String telephone);

    /**
     * 查询验证码是否存在
     *
     * @param key key
     * @return valCode if exists
     */
    String getValCode(String key);

    /**
     * 设置6位数随机验证码
     *
     * @param key key 请求的ip组成
     * @return boolean
     */
    Boolean setValCode(String key);
}
