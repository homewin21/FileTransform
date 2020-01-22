package com.homewin.fileupload.service;

import com.homewin.fileupload.domain.FileObject;
import com.homewin.fileupload.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author homewin
 */
@Service
public class FileServiceImpl implements  FileService {
    Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 获取文件路径
     *
     * @param path 目录路径
     * @return string
     */
    @Override
    public FileObject getPath(String path) {
        return FileUtils.getPath(path);
    }
}
