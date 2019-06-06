package com.zx.commonim.impl;

import com.zx.commonim.api.IMServer;

/**
 * pakage :com.zx.commonim.impl
 * auther :zx
 * creatTime: 2019/6/6
 */
public class NIMService implements IMServer {

    @Override
    public boolean connect(String ip, int port) {
        return false;
    }

    @Override
    public void login(String account, String psw) {

    }

    @Override
    public void sendMessage(Object object) {

    }
}
