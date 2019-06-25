package com.zx.commonim.impl.nim;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.SDKOptions;
import com.netease.nimlib.sdk.StatusBarNotificationConfig;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.constant.MsgStatusEnum;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.CustomMessageConfig;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.msg.model.NIMAntiSpamOption;
import com.netease.nimlib.sdk.uinfo.UserInfoProvider;
import com.netease.nimlib.sdk.uinfo.model.UserInfo;
import com.zx.commonim.AppConfig;
import com.zx.commonim.api.IMessageDecoder;
import com.zx.commonim.constant.MessageStatus;
import com.zx.commonim.api.SendMessageLisenter;
import com.zx.commonim.api.IMessage;
import com.zx.commonim.api.IMServer;
import com.zx.commonim.api.IUserDecoder;
import com.zx.commonim.bean.GeaeIMRecord;
import com.zx.commonim.bean.GeaeIMUser;
import com.zx.commonim.constant.Constants;

import java.util.List;
import java.util.Map;

/**
 * pakage :com.zx.commonim.impl
 * auther :zx
 * creatTime: 2019/6/6
 */
public class NIMService implements IMServer {
    private String TAG = NIMService.class.getSimpleName();
    // 应用配置类
    private AppConfig mConfig;
    // 用户信息类
    private GeaeIMUser mUser;
    // 第三方 用户信息类
    LoginInfo mInfo = null;
    // 用户信息 编、解 器
    IUserDecoder<LoginInfo> mUserDecoder = new NIMUserDecoder();
    // 消息信息  编、解 器
    IMessageDecoder<IMMessage> mMessageDecoder = new NIMMessageDecoder();

    @Override
    public boolean connect(String ip, int port) {
        return connect();
    }

    @Override
    public boolean connect() {
        if (mInfo!=null) {
            NIMClient.init(mConfig.getContext(), mInfo, options());
            return true;
        }
        return false;
    }

    @Override
    public void login(GeaeIMUser user) {
        mUser = user;
        LoginInfo info = mUserDecoder.decode(user); // config...
        RequestCallback<LoginInfo> callback =
                new RequestCallback<LoginInfo>() {
                    @Override
                    public void onSuccess(LoginInfo param) {
                        saveLoginConfig(mConfig.getParser().toJSONString(param));
                    }

                    @Override
                    public void onFailed(int code) {

                    }

                    @Override
                    public void onException(Throwable exception) {

                    }
                };
        NIMClient.getService(AuthService.class).login(info)
                .setCallback(callback);
    }

    private SDKOptions options() {
        SDKOptions options = new SDKOptions();
        // 如果将新消息通知提醒托管给 SDK 完成，需要添加以下配置。否则无需设置。
        StatusBarNotificationConfig config = new StatusBarNotificationConfig();
        config.notificationEntrance = mConfig.getEnterClass(); // 点击通知栏跳转到该Activity
        config.notificationSmallIconId = mConfig.getIcon();
        // 呼吸灯配置
        config.ledARGB = Color.GREEN;
        config.ledOnMs = 1000;
        config.ledOffMs = 1500;
        // 通知铃声的uri字符串
        config.notificationSound = "android.resource://com.netease.nim.demo/raw/msg";
        options.statusBarNotificationConfig = config;

        // 配置保存图片，文件，log 等数据的目录
        // 如果 options 中没有设置这个值，SDK 会使用采用默认路径作为 SDK 的数据目录。
        // 该目录目前包含 log, file, image, audio, video, thumb 这6个目录。
        String sdkPath = mConfig.getAppDir(); // 可以不设置，那么将采用默认路径
        // 如果第三方 APP 需要缓存清理功能， 清理这个目录下面个子目录的内容即可。
        options.sdkStorageRootPath = sdkPath;

        // 配置是否需要预下载附件缩略图，默认为 true
        options.preloadAttach = true;

        // 配置附件缩略图的尺寸大小。表示向服务器请求缩略图文件的大小
        // 该值一般应根据屏幕尺寸来确定， 默认值为 Screen.width / 2
        options.thumbnailSize = mConfig.getScreenWidth() / 2;
        options.userInfoProvider = new UserInfoProvider() {
            @Override
            public UserInfo getUserInfo(String account) {
                UserInfo info = new UserInfo() {
                    @Override
                    public String getAccount() {
                        return mUser == null ? "" : mUser.getAccount();
                    }

                    @Override
                    public String getName() {
                        return mUser == null ? "" : mUser.getName();
                    }

                    @Override
                    public String getAvatar() {
                        return mUser == null ? "" : mUser.getHeadUrl();
                    }
                };
                return info;
            }

            @Override
            public String getDisplayNameForMessageNotifier(String account, String sessionId, SessionTypeEnum sessionType) {
                return null;
            }

            @Override
            public Bitmap getAvatarForMessageNotifier(SessionTypeEnum sessionType, String sessionId) {
                return null;
            }
        };
        return options;
    }

    @Override
    public void sendMessage(IMessage message) {
        if(mUser==null){
            Log.e(TAG,"未获取到登录信息....请先登录"+message.getContent());
            return;
        }
        IMMessage msg = mMessageDecoder.messageDecoder(message);
        setIMMessage(msg);
        sendMessage(msg, message, new SendMessageLisenter() {
            @Override
            public void onSending(IMessage message) {
                Log.e(TAG, message.getContent() + "");
            }

            @Override
            public void onSendSuc(IMessage message) {

            }

            @Override
            public void onFailed(IMessage message) {

            }
        });

    }

    public void sendMessage(final IMMessage msg, final IMessage message, final SendMessageLisenter lisenter) {
        if (lisenter != null) {
            lisenter.onSending(message);
        }
        // 发送给对方
        NIMClient.getService(MsgService.class).sendMessage(msg, false).setCallback(new RequestCallback<Void>() {
            @Override
            public void onSuccess(Void param) {
                msg.setStatus(MsgStatusEnum.success);
                message.setStatus(MessageStatus.SUC);
                if (lisenter != null) {
                    lisenter.onSendSuc(message);
                }
            }

            @Override
            public void onFailed(int code) {
                msg.setStatus(MsgStatusEnum.fail);
                message.setStatus(MessageStatus.FAILED);
                if (lisenter != null) {
                    lisenter.onFailed(message);
                }
            }

            @Override
            public void onException(Throwable exception) {
                exception.printStackTrace();
                Log.e(TAG, "发送异常");
                msg.setStatus(MsgStatusEnum.fail);
                message.setStatus(MessageStatus.FAILED);
                if (lisenter != null) {
                    lisenter.onFailed(message);
                }
            }
        });
    }

    /**
     * 设置远程消息配置
     *
     * @param message
     * @return
     */
    private IMMessage setIMMessage(IMMessage message) {
        Map aMap = mUser.toMap();
        message.setRemoteExtension(aMap);

        Map<String, Object> map = message.getLocalExtension();
        if (map == null) {
            message.setLocalExtension(aMap);
        }
        CustomMessageConfig config = new CustomMessageConfig();
        config.enableRoaming = false;
        message.setConfig(config);
        //忽略易盾
        NIMAntiSpamOption antiSpamOption = new NIMAntiSpamOption();
        antiSpamOption.enable = false;
        message.setNIMAntiSpamOption(antiSpamOption);
        return message;
    }


    @Override
    public NIMService initAppConfig(AppConfig config) {
        this.mConfig = config;
        String account = getAccount();
        if (!TextUtils.isEmpty(account)) {
            mInfo = (LoginInfo) mConfig.getParser().parseObject(account, LoginInfo.class);
        }
        return this;
    }

    @Override
    public String getAccount() {
        return mConfig.getPreference().getString(Constants.NIM_LOGIN_INFO, "");
    }

    @Override
    public void saveLoginConfig(String loginConfig) {
        SharedPreferences.Editor editor = mConfig.getPreference().edit();
        editor.putString(Constants.NIM_LOGIN_INFO, loginConfig);
        editor.commit();
    }

    @Override
    public List<GeaeIMUser> getContactList(String uid) {
        return null;
    }

    @Override
    public List<GeaeIMRecord> getIMRecord(String uid) {
        return null;
    }

}
