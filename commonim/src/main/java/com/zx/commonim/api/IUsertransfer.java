package com.zx.commonim.api;

import com.zx.commonim.bean.GeaeIMUser;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/20
 */
public interface IUsertransfer<T> {
    public T transferTo(GeaeIMUser user);
}
