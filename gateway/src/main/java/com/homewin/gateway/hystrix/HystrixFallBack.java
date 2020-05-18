package com.homewin.gateway.hystrix;

import com.homewin.common.entity.HttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 熔断器启动后的响应返回
 *
 * @author homewin
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixFallBack {
    @RequestMapping("/fallback")
    private HttpResponse fallback() {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setStatus("500");
        httpResponse.setMessage("fuse");
        httpResponse.setTimestamp(String.valueOf(System.currentTimeMillis()));
        return httpResponse;
    }
}
