package com.homewin.fileupload.controller;

import com.homewin.fileupload.domain.FileObject;
import com.homewin.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author homewin
 */
@RestController
@CrossOrigin
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/getPath",method = RequestMethod.GET)
    public FileObject getPath(String path){
        return fileService.getPath(path);
    }
}
