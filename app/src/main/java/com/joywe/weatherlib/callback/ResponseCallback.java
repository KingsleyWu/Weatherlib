package com.joywe.weatherlib.callback;

public interface ResponseCallback<T> {

    /**
     * 成功时回调
     * @param t 成功时需要返回的数据
     */
    void onSuccess(T t);

    /**
     * 失败时回调
     * @param msg 失败信息
     */
    void onFailure(String msg);
}
