package com.zx.commonim.message;

import com.zx.commonim.constant.MessageStatus;
import com.zx.commonim.constant.MessageType;
import com.zx.commonim.impl.BaseMessage;

/**
 * pakage :com.zx.commonim.message
 * auther :zx
 * creatTime: 2019/6/24
 */
public class TextMessage extends BaseMessage implements IMessage<String> {

    private String content;

    public TextMessage(String content) {
        this.content = content;
    }

    public static TextMessage creatTextMessage(String text) {
        return new TextMessage(text);
    }

    @Override
    public MessageStatus getStatus() {
        return null;
    }

    @Override
    public void setStatus(MessageStatus status) {

    }

    @Override
    public MessageType getType() {
        return MessageType.TEXT;
    }

    @Override
    public String getContent() {
        return content;
    }

}