package com.zx.commonim.api;

import com.zx.commonim.constant.MessageStatus;
import com.zx.commonim.constant.MessageType;
import com.zx.commonim.constant.SendType;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/6
 */
public interface IMessage<T> {
    public MessageStatus getStatus();

    public void setStatus(MessageStatus status);

    public MessageType getType();

    public long getId();

    public void setId(long id);

    public String getTime();

    public void setTime(String time);

    public String getFrom();

    public String getTo();

    public T getContent();

    SendType getSendType();

    public void setSendType(SendType sendType);
}
