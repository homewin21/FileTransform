package com.homewin.userservice.util;

import com.homewin.userservice.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author homewin
 */
@Component
public class MongoUtils {
    private final Logger log = LoggerFactory.getLogger(MongoUtils.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据手机号查询是否已存在对应用户
     *
     * @param telephone 手机号
     * @return boolean true:存在 false:不存在
     */
    public boolean existsUser(String telephone) {
        List<User> list = findUser(telephone);
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 对用户进行更新操作包括新增和修改
     *
     * @param user user
     * @return boolean
     */
    public boolean updateUser(User user) {
        try {
            mongoTemplate.save(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * 根据手机号查询对应用户记录
     *
     * @param telephone 手机号
     * @return list of user
     */
    public List<User> findUser(String telephone) {
        Criteria criteria = new Criteria("telephone");
        criteria.is(telephone);
        Query query = new Query(criteria);
        List<User> list = mongoTemplate.find(query, User.class);
        return list;
    }
}
