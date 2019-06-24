package com.zx.commonim.api;

import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zx.commonim.message.IMessage;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/24
 */
public interface SendMessageLisenter {
    public void onSending(IMessage message);

    public void onSendSuc(IMessage message);

    public void onFailed(IMessage message);
}
