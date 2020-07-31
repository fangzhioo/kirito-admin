package com.kirito.cloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    public static final Integer SUCCESS_DEFAULT_CODE = 200;
    public static final String SUCCESS_DEFAULT_MSG = "success";
    public static final Integer FAILED_DEFAULT_CODE = 500;
    public static final String FAILED_DEFAULT_MSG = "failed";

    private Integer code;
    private String msg;
    private T data;

    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(SUCCESS_DEFAULT_CODE,SUCCESS_DEFAULT_MSG,data);
    }

    public static <T> CommonResult<T> failed(){
        return new CommonResult<>(FAILED_DEFAULT_CODE,FAILED_DEFAULT_MSG,null);
    }

    public static <T> CommonResult<T> failed(String msg){
        return new CommonResult<>(FAILED_DEFAULT_CODE,msg,null);
    }

    public static Boolean checkStatus(Integer statusCode){
        return statusCode.equals(SUCCESS_DEFAULT_CODE);
    }

}
