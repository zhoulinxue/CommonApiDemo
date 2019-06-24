package com.zx.commonim.constant;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/6
 */
public enum MessageType {
    TEXT(0), IMAGE(1), VOICE(2), VIDEO(3), CUSTOM(4);

    private int type;

    MessageType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }}
