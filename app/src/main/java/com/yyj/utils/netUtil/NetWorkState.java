package com.yyj.utils.netUtil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by 草帽儿 on 2016/3/7.
 */
public class NetWorkState {
    //检查网络连接状态
    public static boolean isNetWorkConnected(Context context) {
        if (context!=null) {
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }
/**
 * @author yyj
 * create at 2016/3/7 15:04
 * 返回值 -1：没有网络  1：WIFI网络2：wap网络3：net网络
 * @param
 * @return
 */

    public static int getNetType(Context context){
        int netType=-1;
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo==null) {
            return netType;
        }
        int nType=networkInfo.getType();
        if(nType==ConnectivityManager.TYPE_MOBILE)
        {
            if(networkInfo.getExtraInfo().toLowerCase().equals("cmnet"))
            {
                netType = 3;
            }
            else
            {
                netType = 2;
            }
        }
        else if(nType==ConnectivityManager.TYPE_WIFI)
        {
            netType = 1;
        }
        return netType;
    }

}
