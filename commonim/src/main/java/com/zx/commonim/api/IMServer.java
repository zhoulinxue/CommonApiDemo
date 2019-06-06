package com.zx.commonim.api;

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
     * 登录
     *
     * @param account 账号
     * @param psw     密码
     */
    public void login(String account, String psw);

    /**
     * 发送消息
     */
    public void sendMessage(Object object);


}
