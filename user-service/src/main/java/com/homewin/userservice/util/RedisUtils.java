package com.homewin.userservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


/**
 * Redis操作工具类
 *
 * @author homewin
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private final Logger log = LoggerFactory.getLogger(RedisUtils.class);

    /**
     * 判断Key是否存在
     *
     * @param key 键值
     * @return boolean
     */
    public boolean existsKey(String key) {

        try {
            if (key == null || key.length() == 0) {
                log.error("RedisUtils:key is empty!!!");
                return false;
            }
            return redisTemplate.hasKey(key);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            return false;
        }
    }

    /**
     * 获取key值对应value
     *
     * @param key 键值
     * @return String
     */
    public String getKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }


}
