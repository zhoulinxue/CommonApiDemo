package com.zx.commonim.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * pakage :com.zx.commonim.bean
 * auther :zx
 * creatTime: 2019/6/6
 */
public class CommonIMUser {
    private String account;
    private String psw;
    private String name;
    private String headUrl;
    private String uid;

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Map toMap() {
        Map<String, String> userinfos = new HashMap<>();
        userinfos.put("userId", uid);
        userinfos.put("nickname", name);
        userinfos.put("portrait", headUrl);
        return userinfos;
    }
}
