package com.kirito.cloud.common.api;

/**
 * 封装API的错误码
 * Created by kirito  on 2019/4/19.
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
