package com.zx.commonim.api;

/**
 * pakage :com.zx.commonim.api
 * auther :zx
 * creatTime: 2019/6/20
 */

import java.io.UnsupportedEncodingException;

public interface JsonParser {
    // 对象转str
    public String toJSONString(Object object);

    //
    public Object parseObject(String json, Class<?> clazz);

    // 解析集合
    public Object parseArray(String json, Class<?> clazz);

}
