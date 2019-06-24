package com.zx.commonim.api;

import com.zx.commonim.message.IMessage;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/24
 */
public interface IMessageDecoder<T> {
    /**
     * 消息类型统一
     *
     * @param message
     * @return
     */
    public T messageDecoder(IMessage message);


    public IMessage encoder(T t);
}
