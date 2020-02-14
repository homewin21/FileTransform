package com.homewin.fileupload.controller;

import com.homewin.fileupload.domain.FileObject;
import com.homewin.fileupload.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author homewin
 */
@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private FileService fileService;

    /**
     * 查询对应文件夹下的所有文件和文件夹
     * @param path 路径名
     * @return POJO
     */
    @RequestMapping(value = "/getPath",method = RequestMethod.GET)
    public FileObject getPath(String path) throws InterruptedException {
        Thread.sleep(5000);
        return fileService.getPath(path);
    }

    /**
     * 保存上传的文件
     * @param file 文件
     * @param request httpRequest
     * @return result
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public String getFile(MultipartFile file,HttpServletRequest request){
        if (file.isEmpty()){
            return "empty";
        }
        fileService.saveFile(file,request.getParameter("path"));
        return "success";
    }

    /**
     *
     * @param path
     * @return
     */
    @RequestMapping(value = "/mkdir",method = RequestMethod.GET)
    public Boolean mkdir(String path){
        return fileService.mkdir(path);
    }
}
