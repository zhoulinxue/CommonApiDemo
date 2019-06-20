package com.zx.commonim;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zx.commonim.api.IMServer;
import com.zx.commonim.bean.GeaeIMRecord;
import com.zx.commonim.bean.GeaeIMUser;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

/**
 * pakage :com.zx.commonim
 * auther :zx
 * creatTime: 2019/6/6
 */
public class GaeaIMManager {
    private static GaeaIMManager manager;
    private static IMServer imServer;
    private Context mContext;
    private static SharedPreferences mPreference;

    public GaeaIMManager(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 初始化api
     *
     * @param context
     * @return
     */
    public static GaeaIMManager getInstance(Context context) {
        if (manager == null) {
            mPreference = PreferenceManager.getDefaultSharedPreferences(context);
            manager = new GaeaIMManager(context);
        }
        return manager;
    }

    public IMServer init(Class mClass) {
        imServer = (IMServer) create(mClass);
        return imServer;
    }

    public static <T> T create(Class<T> service) {
        try {
            return (T) service.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param user
     */
    public void login(GeaeIMUser user) {
        if (imServer != null) {
            imServer.login(user);
        }
    }

    /**
     * 发送消息
     *
     * @param object
     */
    public void sendMessage(Object object) {
        if (imServer != null) {
            imServer.sendMessage(object);
        }
    }

    /**
     * 连接服务器
     *
     * @param ip
     * @param port
     */
    public void connect(String ip, int port) {
        if (imServer != null) {
            imServer.connect(ip, port);
        }
    }

    /**
     * 获取通讯录
     *
     * @param uid
     * @return
     */
    public List<GeaeIMUser> getContactList(String uid) {
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
    public List<GeaeIMRecord> getRecord(String uid) {
        if (imServer != null) {
            imServer.getIMRecord(uid);
        }
        return new ArrayList<>();
    }

}
