package com.zx.commonim.impl.nim;

import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;

import org.json.JSONException;
import org.json.JSONObject;

public class CustomAttachment implements MsgAttachment {


    private int type = 0;

    private String data = null;

    public CustomAttachment(String jsonObject, int type) {
        this.data = jsonObject;
        this.type = type;

    }

    @Override
    public String toJson(boolean send) {
        return CustomAttachParser.packData(type, data);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDataString() {
        return data;
    }

    public JSONObject getData() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(this.data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public void setData(String data) {
        this.data = data;
    }
}
