package com.homewin.fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author homewin
 */
@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
public class FileuploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileuploadApplication.class, args);
    }

}
