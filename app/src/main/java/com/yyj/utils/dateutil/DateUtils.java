package com.yyj.utils.dateutil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 草帽儿 on 2016/2/18.
 */
public class DateUtils {
    public static String getRequestTime(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String requestTime = dateFormat.format(date);
        return requestTime;
    }
    public static String getRefreshTime(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String refreshTime = dateFormat.format(date);
        return refreshTime;
    }
}
