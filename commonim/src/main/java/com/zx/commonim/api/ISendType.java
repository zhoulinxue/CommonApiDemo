package com.zx.commonim.api;

import com.zx.commonim.constant.SendType;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/24
 */
public interface ISendType<T> {

    public T onSendType(SendType type);
}
