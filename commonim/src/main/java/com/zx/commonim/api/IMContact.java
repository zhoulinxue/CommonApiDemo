package com.zx.commonim.api;

import com.zx.commonim.bean.GeaeIMRecord;
import com.zx.commonim.bean.GeaeIMUser;

import java.util.List;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/6
 */
public interface IMContact {
    public List<GeaeIMUser> getContactList(String uid);

    public List<GeaeIMRecord> getIMRecord(String uid);

}
