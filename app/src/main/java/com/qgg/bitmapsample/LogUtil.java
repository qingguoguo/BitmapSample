package com.qgg.bitmapsample;

import android.util.Log;

/**
 * 作者：王青 wangqing
 * 创建日期：2019/9/24 on 11:00
 * 描述：日志工具类
 */
public class LogUtil {
    private LogUtil() {
    }

    public static void v(String TAG, Object... msg) {
        Log.v(TAG, appendMsg(msg));
    }

    public static void d(String TAG, Object... msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, appendMsg(msg));
        }
    }

    public static void i(String TAG, Object... msg) {
        Log.i(TAG, appendMsg(msg));
    }

    public static void w(String TAG, Object... msg) {
        Log.w(TAG, appendMsg(msg));
    }

    public static void e(String TAG, Object... msg) {
        Log.e(TAG, appendMsg(msg));
    }

    private static String appendMsg(Object[] msg) {
        if (msg == null || msg.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object s : msg) {
            if (s != null) {
                stringBuilder.append(s.toString()).append(" ");
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }
}
