package com.zx.commonim.impl;

import com.zx.commonim.api.MessageStatus;
import com.zx.commonim.api.MessageType;
import com.zx.commonim.message.IMessage;

/**
 * pakage :com.zx.commonim.impl
 * auther :zx
 * creatTime: 2019/6/24
 */
public class BaseMessage {
    private long id;
    private MessageType type;
    private String time;
    private String from;
    private String to;
    private MessageStatus status=MessageStatus.SENDING;

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
