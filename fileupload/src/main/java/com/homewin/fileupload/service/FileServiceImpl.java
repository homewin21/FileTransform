package com.homewin.fileupload.service;

import com.homewin.fileupload.domain.FileObject;
import com.homewin.fileupload.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


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
        log.info("FileService:getPath==========> path:"+path);
        return FileUtils.getPath(path);
    }

    /**
     * 保存上传的文件到对应路径下
     * @param file 上传的文件
     * @param path 文件路径
     * @return boolean 是否保存成功
     */
    @Override
    public Boolean saveFile(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        log.info("FileService:saveFile==========> filePath:"+path+fileName);
        File temp = new File(path,fileName);
        try {
            file.transferTo(temp);
        }catch (Exception e){
            log.error(e.toString(),e);
        }
        return null;
    }

    /**
     * @param path
     * @return
     */
    @Override
    public Boolean mkdir(String path) {
        File file = new File(path);
        return file.mkdir();
    }


}
