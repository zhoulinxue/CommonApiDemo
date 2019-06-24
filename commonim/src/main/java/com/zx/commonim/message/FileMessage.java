package com.zx.commonim.message;

import com.zx.commonim.impl.BaseMessage;

import java.io.File;

/**
 * pakage :com.zx.commonim.message
 * auther :zx
 * creatTime: 2019/6/24
 */
public class FileMessage extends BaseMessage implements IMessage<File> {
    private String filePath;

    @Override
    public File getContent() {
        return new File(filePath);
    }

}
