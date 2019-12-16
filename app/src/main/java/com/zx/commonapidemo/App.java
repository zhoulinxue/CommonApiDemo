package com.zx.commonapidemo;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.zx.commonim.AppConfig;
import com.zx.commonim.CommonIMManager;
import com.zx.commonim.impl.nim.NIMService;

/**
 * pakage :com.zx.commonapidemo
 * auther :zx
 * creatTime: 2019/6/25
 */
public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initIm();
    }

    private void initIm() {
        AppConfig config = new AppConfig(this, new GsonParser());
        config.setPreference(PreferenceManager.getDefaultSharedPreferences(this));
        config.setEnterClass(MainActivity.class);
        config.setIcon(R.mipmap.ic_launcher);
        config.setAppDir(getCacheDir() + "/nim");
        config.setScreenWidth(1080);
        CommonIMManager.getInstance(this).creatServer(NIMService.class).initAppConfig(config).connect();
    }

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
    }
}
