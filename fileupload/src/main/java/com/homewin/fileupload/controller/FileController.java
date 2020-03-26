package com.homewin.fileupload.controller;

import com.homewin.fileupload.domain.FileObject;
import com.homewin.fileupload.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author homewin
 */
@RefreshScope
@RestController
@RequestMapping("/file")
public class FileController {
    private Logger log = LoggerFactory.getLogger(getClass());
    private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * 查询对应文件夹下的所有文件和文件夹
     * @param path 路径名
     * @return POJO
     */
    @RequestMapping(value = "/getPath",method = RequestMethod.GET)
    private FileObject getPath(String path) {
        log.info("getPath");
        return fileService.getPath(path);
    }

    /**
     * 保存上传的文件
     * @param file 文件
     * @param request httpRequest
     * @return result
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    private String getFile(MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()){
            return "empty";
        }
        fileService.saveFile(file,request.getParameter("path"));
        return "success";
    }

    /**
     * 在对应路径下新建文件夹
     * @param path 文件路径
     * @return boolean 是否新建成功
     */
    @RequestMapping(value = "/mkdir",method = RequestMethod.GET)
    private Boolean mkdir(String path) {
        return fileService.mkdir(path);
    }
}
