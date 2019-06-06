package com.zx.commonim;

import com.zx.commonim.api.IMContact;
import com.zx.commonim.api.IMPlatform;
import com.zx.commonim.api.IMSender;
import com.zx.commonim.api.IMServer;
import com.zx.commonim.bean.GeaeIMRecord;
import com.zx.commonim.bean.GeaeIMUser;
import com.zx.commonim.impl.NIMContact;
import com.zx.commonim.impl.NIMSender;
import com.zx.commonim.impl.NIMService;

import java.util.ArrayList;
import java.util.List;

/**
 * pakage :com.zx.commonim
 * auther :zx
 * creatTime: 2019/6/6
 */
public class GaeaIMManager {

    private static IMSender mSender;
    private static IMServer imServer;
    private static IMContact mContact;

    /**
     * 初始化sdk  平台
     *
     * @param platform
     */
    public static void init(IMPlatform platform) {
        switch (platform) {
            case NIM:
                mSender = new NIMSender();
                imServer = new NIMService();
                mContact = new NIMContact();
                break;
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
        if (mContact != null) {
            return mContact.getContactList(uid);
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
        if (mContact != null) {
            mContact.getIMRecord(uid);
        }
        return new ArrayList<>();
    }

}
