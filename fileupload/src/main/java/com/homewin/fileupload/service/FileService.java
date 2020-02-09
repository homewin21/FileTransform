package com.homewin.fileupload.service;

import com.homewin.fileupload.domain.FileObject;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author homewin
 */
public interface FileService {
    /**
     * 获取文件路径下的文件和文件夹
     * @param path 目录路径
     * @return string
     */
    FileObject getPath(String path);

    /**
     * 保存上传的文件到对应路径下
     * @param file 上传的文件
     * @param path 文件路径
     * @return boolean 是否保存成功
     */
    Boolean saveFile(MultipartFile file,String path);

    /**
     *
     * @param path
     * @return
     */
    Boolean mkdir (String path);
}
