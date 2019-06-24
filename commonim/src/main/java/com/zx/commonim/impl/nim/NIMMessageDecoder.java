package com.zx.commonim.impl.nim;

import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zx.commonim.api.IMessageDecoder;
import com.zx.commonim.api.ISendType;
import com.zx.commonim.api.JsonParser;
import com.zx.commonim.constant.Constants;
import com.zx.commonim.constant.SendType;
import com.zx.commonim.api.IMessage;
import com.zx.commonim.impl.FastjsonParser;
import com.zx.commonim.message.ImageMessage;
import com.zx.commonim.utils.Base64Utils;

/**
 * pakage :com.zx.commonim.impl
 * auther :zx
 * creatTime: 2019/6/24
 */
public class NIMMessageDecoder implements IMessageDecoder<IMMessage>, ISendType<SessionTypeEnum> {
    private JsonParser mParser = new FastjsonParser();

    @Override
    public IMMessage messageDecoder(IMessage message) {
        IMMessage msg = null;
        SessionTypeEnum type = onSendType(message.getSendType());
        switch (message.getType()) {
            case TEXT:
                msg = MessageBuilder.createTextMessage(message.getTo(), type, message.getContent() + "");
                break;
            case IMAGE:
                ImageMessage imageMessage = (ImageMessage) message;
                msg = MessageBuilder.createFileMessage(message.getTo(), type, imageMessage.getContent(), "[图片]");
                break;
            case CUSTOM:
                CustomTextMsg textMsg = new CustomTextMsg();
                textMsg.setContent(Base64Utils.encode(message.getContent() + ""));
                CustomAttachment attachment = new CustomAttachment(mParser.toJSONString(textMsg), Constants.Msg.IM_TYPE_CUSTOM_TEXT);
                msg = MessageBuilder.createCustomMessage(message.getTo(), type, attachment);
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
