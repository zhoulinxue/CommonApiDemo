package com.zx.commonim.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Base64;

/**
 * pakage :com.gaea.kiki.utils
 * auther :zx
 * creatTime: 2019/4/3
 */
public class Base64Utils {

    static String[] baseTransfer = {"v", "V", "q", "Q", "O", "o", "X", "x"};
    static String[] baseTransferTo = {".", "-", "_", "%", "&", "*", "$", "^"};

    @SuppressLint("NewApi")
    public static String encode(String content) {
        byte[] bytes = Base64.encode(content.getBytes(), Base64.NO_WRAP);
        String base64 = new String(bytes);
        System.out.println(base64);

        return transfer(base64);
    }

    private static String transfer(String base64) {
        if (!TextUtils.isEmpty(base64)) {
            for (int i = 0; i < baseTransfer.length; i++) {
                if (base64.contains(baseTransfer[i])) {
                    base64 = base64.replace(baseTransfer[i], baseTransferTo[i]);
                }
            }
            return base64;
        } else {
            return "";
        }
    }

    @SuppressLint("NewApi")
    public static String decode(String content) {
        byte[] byresult = null;
        try {
            byresult = Base64.decode(transferTo(content), Base64.NO_WRAP);
        } catch (Exception e) {
            return content;
        }
        String resut = new String(byresult);
        return resut;
    }

    private static String transferTo(String resut) {
        if (!TextUtils.isEmpty(resut)) {
            for (int i = 0; i < baseTransferTo.length; i++) {
                if (resut.contains(baseTransferTo[i])) {
                    resut = resut.replace(baseTransferTo[i], baseTransfer[i]);
                }
            }
            return resut;
        } else {
            return "";
        }
    }

    public static void main(String[] args) {

        String base64 = Base64Utils.encode("微信Vsdas红果");
        System.out.println(base64);

        String result = Base64Utils.decode(base64);
        System.out.println(result);

    }
}
