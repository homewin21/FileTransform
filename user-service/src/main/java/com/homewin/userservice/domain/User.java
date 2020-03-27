package com.homewin.userservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author homewin
 */
@ToString
public class User {
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String telephone;
}
