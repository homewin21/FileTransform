package com.homewin.userservice.controller;

import com.homewin.common.entity.HttpResponse;
import com.homewin.userservice.service.UserService;
import com.homewin.userservice.util.IpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author homewin
 */
@Api(value = "UserController", tags = {"UserController"})
@RestController
@RequestMapping("/user")
public class UserController {
    private final static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ApiOperation("是否已经存在该手机号的注册记录")
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

    @RequestMapping(value = "/gerValCode", method = RequestMethod.GET)
    private String test(HttpServletRequest request) {
        log.info(IpUtils.getIpAddr(request));
        return "1";
    }
}
