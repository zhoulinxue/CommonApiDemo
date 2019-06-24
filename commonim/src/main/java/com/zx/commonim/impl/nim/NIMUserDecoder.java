package com.zx.commonim.impl.nim;

import com.netease.nimlib.sdk.auth.LoginInfo;
import com.zx.commonim.api.IUserDecoder;
import com.zx.commonim.bean.GeaeIMUser;

/**
 * pakage :com.zx.commonim.impl
 * auther :zx
 * creatTime: 2019/6/24
 */
public class NIMUserDecoder implements IUserDecoder<LoginInfo> {
    @Override
    public LoginInfo decode(GeaeIMUser user) {
        return user == null ? null : new LoginInfo(user.getAccount(), user.getPsw());
    }

    @Override
    public GeaeIMUser encode(LoginInfo loginInfo) {
        return null;
    }
}
