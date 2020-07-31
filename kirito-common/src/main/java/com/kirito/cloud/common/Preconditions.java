package com.kirito.cloud.common;

import com.kirito.cloud.exception.CustomCheckException;

/**
 * 校验参数， 统一抛出自定义错误
 * 参考自  com.google.common.base.Preconditions
 *
 */
public final class Preconditions {
    private Preconditions(){};
    private static final String ERROR_MSG = "服务器异常，请稍后再试～";
    /**
     * 检查表达式状态
     * @param b
     * @throws CustomCheckException
     */
    public static void checkState(boolean b) throws CustomCheckException {
        if(!b){
            throw new CustomCheckException(ERROR_MSG);
        }
    };

    /**
     * 检查表达式状态
     * @param b 返回Boolean的表达式
     * @param msg 错误信息
     * @throws CustomCheckException 自定义异常
     */
    public static void checkState(boolean b, String msg) throws CustomCheckException {
        if(!b){
            throw new CustomCheckException(msg);
        }
    };

    public static <T> T checkNotNull(T obj) throws CustomCheckException{
        if (obj == null){
            throw new CustomCheckException(ERROR_MSG);
        }else {
            return obj;
        }
    }

    /**
     * 检查是否为null
     * @param obj
     * @param msg
     * @param <T>
     * @return
     * @throws CustomCheckException
     */
    public static <T> T checkNotNull(T obj,String msg) throws CustomCheckException{
        if (obj == null){
            throw new CustomCheckException(msg);
        }else {
            return obj;
        }
    }


}
