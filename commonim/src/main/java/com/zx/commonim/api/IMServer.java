package com.zx.commonim.api;

import com.zx.commonim.AppConfig;
import com.zx.commonim.bean.CommonIMRecord;
import com.zx.commonim.bean.CommonIMUser;

import java.util.List;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/6
 */
public interface IMServer {

    /**
     * 创建连接
     *
     * @return 是否连接成功
     */
    public boolean connect(String ip, int port);

    /**
     * 创建连接
     *
     * @return 是否连接成功
     */
    public boolean connect();

    /**
     * @param user
     */
    public void login(CommonIMUser user);

    /**
     * 发送消息
     */
    public void sendMessage(IMessage message);

    /**
     * 发送 消息
     * @param message 消息
     * @param lisenter 发送监听
     */
    public void sendMessage(IMessage message,SendMessageLisenter lisenter);



    /**
     * @param config
     */
    public IMServer initAppConfig(AppConfig config);

    /**
     * 获取 用户资料
     * @return
     */
    public String getAccount();

    /**
     * 缓存用户资料
     * @param userInfo
     */
    public void saveLoginConfig(String userInfo);

    /**
     *
     * @param uid
     * @return
     */
    public List<CommonIMUser> getContactList(String uid);

    /**
     *
     * @param uid
     * @return
     */
    public List<CommonIMRecord> getIMRecord(String uid);

    /**
     * 退出登录
     */
    public void logout();
}
