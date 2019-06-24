package com.zx.commonim.impl.nim;

import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zx.commonim.api.IMessageDecoder;
import com.zx.commonim.api.ISendType;
import com.zx.commonim.constant.SendType;
import com.zx.commonim.api.IMessage;
import com.zx.commonim.message.ImageMessage;

/**
 * pakage :com.zx.commonim.impl
 * auther :zx
 * creatTime: 2019/6/24
 */
public class NIMMessageDecoder implements IMessageDecoder<IMMessage>, ISendType<SessionTypeEnum> {
    @Override
    public IMMessage messageDecoder(IMessage message) {
        IMMessage msg = null;
        switch (message.getType()) {
            case TEXT:
                msg = MessageBuilder.createTextMessage(message.getTo(), onSendType(message.getSendType()), message.getContent() + "");
                break;
            case IMAGE:
                ImageMessage imageMessage = (ImageMessage) message;
                msg = MessageBuilder.createFileMessage(message.getTo(), onSendType(message.getSendType()), imageMessage.getContent(), "[图片]");
                break;
        }
        return msg;
    }

    @Override
    public IMessage encoder(IMMessage message) {
        return null;
    }

    @Override
    public SessionTypeEnum onSendType(SendType type) {
        SessionTypeEnum typeEnum = SessionTypeEnum.P2P;
        switch (type) {
            case GROUP:
                typeEnum = SessionTypeEnum.ChatRoom;
                break;
        }
        return typeEnum;
    }
}
