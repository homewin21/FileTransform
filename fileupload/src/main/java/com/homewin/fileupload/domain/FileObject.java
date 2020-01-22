package com.homewin.fileupload.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * @author homewin
 */
@ToString
public class FileObject {
    /**
     * 文件列表
     */
    @Getter
    @Setter
    private List<String> fileList;
    /**
     * 文件夹列表
     */
    @Setter
    @Getter
    private List<String> foldList;
}
