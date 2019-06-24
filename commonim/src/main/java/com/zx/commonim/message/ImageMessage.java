package com.zx.commonim.message;

/**
 * pakage :com.zx.commonim.message
 * auther :zx
 * creatTime: 2019/6/24
 */
public class ImageMessage extends FileMessage {
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
