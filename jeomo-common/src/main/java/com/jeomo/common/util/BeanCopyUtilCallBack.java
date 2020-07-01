package com.jeomo.common.util;

/**
 * 为了使BeanUtils可以转换集合对象，可在这个Callback
 *
 * @Author: qbt
 * @Date: 2020/6/30 15:50
 * @Version 1.0
 */
@FunctionalInterface
public interface BeanCopyUtilCallBack<S, T> {
    void callBack(S s, T t);
}
