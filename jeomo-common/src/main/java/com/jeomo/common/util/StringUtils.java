package com.jeomo.common.util;

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
    
  
    /**
     * <p>方法说明：将指定的padding填充到src尾部，使src达到长度length</p>
     * @param src
     * @param padding
     * @param length
     * @author qibotian
     * @time 2020年7月13日 下午4:09:46
     */
    public static String tailAppend(String src, char padding, int length){
    	int srcLength = src.length();
    	int tl = length - srcLength;
    	StringBuilder builder = new StringBuilder(src);
    	for(int i = 1; i <= tl; i++) {
    		builder.append(padding);
    	}
    	return builder.toString();
    }
    
    /**
     * <p>方法说明：将指定的padding填充到src头部，使src达到长度length</p>
     * @param src
     * @param padding
     * @param length
     * @author qibotian
     * @time 2020年7月13日 下午4:09:46
     */
    public static String headerAppend(String src, char padding, int length) {
    	int srcLength = src.length();
    	int tl = length - srcLength;
    	StringBuilder builder = new StringBuilder();
    	for(int i = 1; i <= tl; i++) {
    		builder.append(padding);
    	}
    	builder.append(src);
    	return builder.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(headerAppend("1", '0', 5));
	}


}
