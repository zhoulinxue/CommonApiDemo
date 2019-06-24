package com.zx.commonim.impl.nim;

import android.util.Log;

import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachmentParser;

import org.json.JSONException;
import org.json.JSONObject;

public class CustomAttachParser implements MsgAttachmentParser {


    public static final String CUSTOM_TYPE = "type";
    public static final String CUSTOM_DATA = "data";
    @Override
    public MsgAttachment parse(String json) {
        Log.e("*****CustomAttachParser", "json:" + json);
        CustomAttachment attachment = null;
        try {
            JSONObject object = new JSONObject(json);
            int type = object.getInt(CUSTOM_TYPE);
            JSONObject data = object.getJSONObject(CUSTOM_DATA);

            attachment = new CustomAttachment(data.toString(), type);

        } catch (Exception e) {

        }

        return attachment;
    }


    public static String packData(int type, String data) {
        JSONObject object = new JSONObject();
        try {
            object.put(CUSTOM_TYPE, type);
            if (data != null) {
                object.put(CUSTOM_DATA, new JSONObject(data));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }
}
