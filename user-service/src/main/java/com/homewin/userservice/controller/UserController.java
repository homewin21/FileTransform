package com.homewin.userservice.controller;

import com.homewin.common.entity.HttpResponse;
import com.homewin.userservice.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author homewin
 */
@Api(value = "UserController", tags = {"UserController"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/existsUser", method = RequestMethod.GET)
    private HttpResponse<Boolean> existsUser(String telephone) {
        HttpResponse<Boolean> httpResponse = new HttpResponse<>();
        try {
            httpResponse.setResponseData(userService.existsUser(telephone));
            httpResponse.setStatus("200");
            httpResponse.setMessage("success");
        } catch (Exception ex) {
            httpResponse.setStatus("500");
            httpResponse.setMessage("fail");
            ex.printStackTrace();
        }
        httpResponse.setTimestamp(String.valueOf(System.currentTimeMillis()));
        return httpResponse;
    }
}
