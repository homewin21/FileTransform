package com.homewin.fileupload.controller;

import com.homewin.common.entity.HttpResponse;
import com.homewin.fileupload.domain.FileObject;
import com.homewin.fileupload.service.FileService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author homewin
 */
@Api(value = "FileController", tags = {"FileController"})
@RestController
@RequestMapping("/file")
public class FileController {
    private Logger log = LoggerFactory.getLogger(FileController.class);
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
    private HttpResponse<FileObject> getPath(String path) {
        HttpResponse<FileObject> httpResponse = new HttpResponse<>();
        try {
            httpResponse.setResponseData(fileService.getPath(path));
            httpResponse.setMessage("success");
            httpResponse.setStatus("200");
            httpResponse.setTimestamp(String.valueOf(System.currentTimeMillis()));
        } catch (Exception ex) {
            httpResponse.setStatus("500");
            httpResponse.setMessage(ex.getMessage());
            log.error(ex.getMessage());
        }
        return httpResponse;
    }

    /**
     * 保存上传的文件
     * @param file 文件
     * @param request httpRequest
     * @return result
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    private HttpResponse<Boolean> getFile(MultipartFile file, HttpServletRequest request) {
        HttpResponse<Boolean> httpResponse = new HttpResponse<>();
        try {
            httpResponse.setResponseData(fileService.saveFile(file, request.getParameter("path")));
            httpResponse.setStatus("200");
            httpResponse.setMessage("success");
        } catch (Exception ex) {
            httpResponse.setStatus("500");
            httpResponse.setMessage("fail");
        }
        httpResponse.setTimestamp(String.valueOf(System.currentTimeMillis()));
        fileService.saveFile(file,request.getParameter("path"));
        return httpResponse;
    }

    /**
     * 在对应路径下新建文件夹
     * @param path 文件路径
     * @return boolean 是否新建成功
     */
    @RequestMapping(value = "/mkdir",method = RequestMethod.GET)
    private HttpResponse<Boolean> mkdir(String path) {
        HttpResponse<Boolean> httpResponse = new HttpResponse<>();
        try {
            httpResponse.setResponseData(fileService.mkdir(path));
            httpResponse.setStatus("200");
            httpResponse.setMessage("success");
        } catch (Exception ex) {
            httpResponse.setStatus("500");
            httpResponse.setMessage("fail");
        }
        return httpResponse;
    }
}
