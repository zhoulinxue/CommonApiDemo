package com.zx.commonim.api;

import com.zx.commonim.AppConfig;
import com.zx.commonim.bean.GeaeIMRecord;
import com.zx.commonim.bean.GeaeIMUser;
import com.zx.commonim.message.IMessage;
import com.zx.commonim.impl.NIMService;

import java.util.List;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/6
 */
public interface IMServer<T> {

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
    public void login(GeaeIMUser user);

    /**
     * 发送消息
     */
    public void sendMessage(IMessage message);

    /**
     * 消息类型统一
     * @param message
     * @return
     */
    public T messageDecoder(IMessage message);

    /**
     * @param config
     */
    public NIMService initAppConfig(AppConfig config);

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
    public List<GeaeIMUser> getContactList(String uid);

    /**
     *
     * @param uid
     * @return
     */
    public List<GeaeIMRecord> getIMRecord(String uid);
}
