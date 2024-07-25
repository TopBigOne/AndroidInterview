package com.jar.ndk;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/7/23 19:55
 * @Desc :
 */
public class Utils {
    private static final String PATTERN_yyyyMMddHHmmssSSS = "yyyy-MM-dd HH:mm:ss：SSS";

    public static String formatDatetime(long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_yyyyMMddHHmmssSSS, Locale.CHINA);
        return dateFormat.format(date);
    }

    public static String formatStr(String pattern, Object... params) {
        if (TextUtils.isEmpty(pattern)) return null;
        try {
            return String.format(pattern, params);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
