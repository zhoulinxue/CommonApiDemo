//package com.zx.commonim.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.zx.commonim.api.IJsonParser;
//
///**
// * pakage :com.zx.commonim.impl
// * auther :zx
// * creatTime: 2019/6/20
// */
//public class FastjsonParser implements IJsonParser {
//    @Override
//    public String toJSONString(Object object) {
//        return JSONObject.toJSONString(object);
//    }
//
//    @Override
//    public Object parseObject(String json, Class<?> clazz) {
//        return JSONObject.parseObject(json, clazz);
//    }
//
//    @Override
//    public Object parseArray(String json, Class<?> clazz) {
//        return JSONObject.parseArray(json,clazz);
//    }
//}
