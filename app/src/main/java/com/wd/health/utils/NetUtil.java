package com.wd.health.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @Description: 类作用描述
 * @Author: 高晨凯
 * @CreateDate: 2020/1/7 14:08
 */
public class NetUtil {
    public static boolean hasNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

}
