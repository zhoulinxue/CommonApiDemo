package com.zx.commonim;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zx.commonim.api.JsonParser;
import com.zx.commonim.impl.FastjsonParser;
import com.zx.commonim.utils.Constants;

/**
 * pakage :com.zx.commonim
 * auther :zx
 * creatTime: 2019/6/20
 */
public class AppConfig {
    private Class mEnterClass;
    private int icon;
    private String appDir;
    private int mScreenWidth;
    private Context mContext;
    private SharedPreferences mPreference;
    private JsonParser mParser;

    public JsonParser getParser() {
        return mParser;
    }

    public void setParser(JsonParser mParser) {
        this.mParser = mParser;
    }

    public SharedPreferences getPreference() {
        return mPreference;
    }

    public void setPreference(SharedPreferences mPreference) {
        this.mPreference = mPreference;
    }

    public AppConfig(Context mContext) {
        this.mContext = mContext;
        mPreference = PreferenceManager.getDefaultSharedPreferences(mContext);
        mParser=new FastjsonParser();
    }

    public Class getEnterClass() {
        return mEnterClass;
    }

    public void setEnterClass(Class mEnterClass) {
        this.mEnterClass = mEnterClass;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getAppDir() {
        return appDir;
    }

    public void setAppDir(String appDir) {
        this.appDir = appDir;
    }

    public int getScreenWidth() {
        return mScreenWidth;
    }

    public void setScreenWidth(int mScreenWidth) {
        this.mScreenWidth = mScreenWidth;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }
}
