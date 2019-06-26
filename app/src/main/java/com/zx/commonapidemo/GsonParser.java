package com.zx.commonapidemo;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.zx.commonim.api.IJsonParser;

import java.util.List;

/**
 * pakage :com.zx.commonapidemo
 * auther :zx
 * creatTime: 2019/6/25
 */
public class GsonParser  implements IJsonParser {
    @Override
    public String toJSONString(Object object) {
        return GsonUtils.toJsonString(object);
    }

    @Override
    public Object parseObject(String json, Class<?> clazz) {
        return GsonUtils.fromJsonString(json,clazz);
    }

    @Override
    public List<?> parseArray(String json, Class<?> clazz) {
        return GsonUtils.toList(json);
    }


}
