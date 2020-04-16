package com.homewin.userservice.domain;

import lombok.Data;
/**
 * @author homewin
 */
@Data
public class User {
    private String _id;
    private String username;
    private String password;
    private String telephone;
    /**
     * 记录是否可用 1：可用 0：无效
     */
    private String isValid;
}
