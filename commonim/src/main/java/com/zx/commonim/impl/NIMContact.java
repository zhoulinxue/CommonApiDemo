package com.zx.commonim.impl;

import com.zx.commonim.api.IMContact;
import com.zx.commonim.bean.GeaeIMRecord;
import com.zx.commonim.bean.GeaeIMUser;

import java.util.List;

/**
 * pakage :com.zx.commonim.impl
 * auther :zx
 * creatTime: 2019/6/6
 */
public class NIMContact implements IMContact {
    @Override
    public List<GeaeIMUser> getContactList(String uid) {
        return null;
    }

    @Override
    public List<GeaeIMRecord> getIMRecord(String uid) {
        return null;
    }
}
