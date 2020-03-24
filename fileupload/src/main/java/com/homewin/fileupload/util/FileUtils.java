package com.homewin.fileupload.util;

import com.homewin.fileupload.domain.FileObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author homewin
 */
public class FileUtils {
    /**
     * 获取对应路径下的所有文件和文件夹
     *
     * @param path 路径
     * @return fileObject
     */
    public static FileObject getPath(String path){
        List<String> fileList =  new ArrayList<>();
        List<String> foldList = new ArrayList<>();
        File file = new File(path);
        for (File temp : Objects.requireNonNull(file.listFiles())) {
            if (temp.isFile()) {
                fileList.add(temp.getName());
            } else {
                foldList.add(temp.getName());
            }
        }
        FileObject fileObject = new FileObject();
        fileObject.setFileList(fileList);
        fileObject.setFoldList(foldList);
        return fileObject;
    }
}
