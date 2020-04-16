package com.homewin.fileupload;

import com.homewin.fileupload.service.FileService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootTest
class FileuploadApplicationTests {
    private Logger log = LoggerFactory.getLogger(FileuploadApplicationTests.class);
    @Autowired
    FileService fileService;
    @Test
    @RequestMapping("/test")
    void contextLoads() {
        log.info("test");
    }

}
