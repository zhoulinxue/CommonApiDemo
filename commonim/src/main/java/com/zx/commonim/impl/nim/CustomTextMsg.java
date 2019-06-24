package com.zx.commonim.impl.nim;

import java.io.Serializable;

/**
 * pakage :com.zx.commonim.impl.nim
 * auther :zx
 * creatTime: 2019/6/24
 */
public class CustomTextMsg implements Serializable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
