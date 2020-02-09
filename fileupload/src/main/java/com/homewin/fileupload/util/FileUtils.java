package com.homewin.fileupload.util;

import com.homewin.fileupload.domain.FileObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author homewin
 */
public class FileUtils {
    public static FileObject getPath(String path){
        List<String> fileList =  new ArrayList<>();
        List<String> foldList = new ArrayList<>();
        File file = new File(path);
        if (file.listFiles() != null) {
            for (File temp : file.listFiles()) {
                if (temp.isFile()) {
                    fileList.add(temp.getName());
                } else {
                    foldList.add(temp.getName());
                }
            }
        }
        FileObject fileObject = new FileObject();
        fileObject.setFileList(fileList);
        fileObject.setFoldList(foldList);
        return fileObject;
    }
}
