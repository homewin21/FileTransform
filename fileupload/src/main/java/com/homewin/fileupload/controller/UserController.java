package com.homewin.fileupload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author homewin
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/register")
    public Boolean register(){
        return true;
    }

    public Boolean login(){
        return null;
    }

}
