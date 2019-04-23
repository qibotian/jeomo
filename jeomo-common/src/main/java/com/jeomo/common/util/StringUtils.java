package com.jeomo.common.util;

import org.springframework.lang.Nullable;

/**
 * 字符串工具类
 * @Author: qbt
 * @Date: 2019/4/22 22:43
 * @Version 1.0
 */
public class StringUtils {

    /**
     * 驼峰字符串转为下划线
     * @param param
     * @return
     */
    public static String camelToUnderline(String param) {
        if(org.springframework.util.StringUtils.isEmpty(param)) {
            return param;
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 判断是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }


}
