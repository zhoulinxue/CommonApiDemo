package com.zx.commonim;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zx.commonim.api.IMessage;
import com.zx.commonim.api.IMServer;
import com.zx.commonim.api.SendMessageLisenter;
import com.zx.commonim.bean.CommonIMRecord;
import com.zx.commonim.bean.CommonIMUser;

import java.util.ArrayList;
import java.util.List;

/**
 * pakage :com.zx.commonim
 * auther :zx
 * creatTime: 2019/6/6
 */
public class CommonIMManager {
    private static CommonIMManager manager;
    private static IMServer imServer;
    private Context mContext;
    private static SharedPreferences mPreference;

    public CommonIMManager(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 初始化api
     *
     * @param context
     * @return
     */
    public static CommonIMManager getInstance(Context context) {
        if (manager == null) {
            mPreference = PreferenceManager.getDefaultSharedPreferences(context);
            manager = new CommonIMManager(context);
        }
        return manager;
    }

    public IMServer creatServer(Class mClass) {
        imServer = (IMServer) create(mClass);
        return imServer;
    }

    private static <T> T create(Class<T> service) {
        try {
            return (T) service.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param message
     */
    public void sendMessage(IMessage message) {
        if (imServer != null) {
            imServer.sendMessage(message);
        }
    }

    /**
     * @param message
     */
    public void sendMessage(IMessage message, SendMessageLisenter lisenter) {
        if (imServer != null) {
            imServer.sendMessage(message, lisenter);
        }
    }

    /**
     * 获取通讯录
     *
     * @param uid
     * @return
     */
    public List<CommonIMUser> getContactList(String uid) {
        if (imServer != null) {
            return imServer.getContactList(uid);
        }
        return new ArrayList<>();
    }

    /**
     * 获取最近聊天
     *
     * @param uid
     * @return
     */
    public List<CommonIMRecord> getRecord(String uid) {
        if (imServer != null) {
            imServer.getIMRecord(uid);
        }
        return new ArrayList<>();
    }

    public void logOut(){
        if(imServer!=null){
            imServer.logout();
        }
    }

}
