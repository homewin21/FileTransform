package com.homewin.userservice;

import com.homewin.userservice.util.MongoUtils;
import com.homewin.userservice.util.RedisUtils;
import com.homewin.userservice.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class UserServiceApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RedisUtils utils;
    @Autowired
    private MongoUtils mongoUtils;

    @Test
    void contextLoads() {
        User user = new User();
//        user.setUserId("1");
        user.setTelephone("13000000000");
        user.setUsername("homewin");
        user.setPassword("pwd");
//        mongoTemplate.insert(user);

    }

    @Test
    void contextLoads1() {
        String key = "test1";
        if (utils.existsKey(key)) {
            System.out.println(utils.getKey(key));
        } else {
            System.out.println("key isn't exists");
        }
    }

    @Test
    void userCRUD() {
        User u = new User();
        u.setUsername("test");
        u.setPassword("123");
        u.setTelephone("130");
        mongoUtils.updateUser(u);
        if (mongoUtils.existsUser("130")) {
            for (User user : mongoUtils.findUser("130")) {
                System.out.println(user);
            }
        }

    }

}
