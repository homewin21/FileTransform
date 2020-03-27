package com.homewin.userservice;

import com.homewin.userservice.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
class UserServiceApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUserId("1");
        user.setTelephone("13000000000");
        user.setUsername("homewin");
        user.setPassword("pwd");
        mongoTemplate.insert(user);

    }

}
