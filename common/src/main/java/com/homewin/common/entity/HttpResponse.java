package com.homewin.common.entity;

import lombok.Data;

/**
 * @author homewin
 */
@Data
public class HttpResponse<T> {
    private String status;
    private String message;
    private String timestamp;
    private T responseData;
}
