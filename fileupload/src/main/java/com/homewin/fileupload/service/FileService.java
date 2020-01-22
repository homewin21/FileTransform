package com.homewin.fileupload.service;

import com.homewin.fileupload.domain.FileObject;

/**
 * @author homewin
 */
public interface FileService {
    /**
     * 获取文件路径
     * @param path 目录路径
     * @return string
     */
    FileObject getPath(String path);
}
