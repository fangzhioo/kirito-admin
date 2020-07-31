package com.kirito.cloud.handler;

import com.kirito.cloud.CommonResult;
import com.kirito.cloud.exception.CustomCheckException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Component
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult handleException(Exception e){
        log.error(e.toString());
        return CommonResult.failed(e.getMessage());
    }

    /**
     * 校验参数时，获取校验错误返回；
     * @param e
     * @return
     */
    @ExceptionHandler(CustomCheckException.class)
    @ResponseBody
    public CommonResult handleException(CustomCheckException e){
        log.error(e.toString());
        return CommonResult.failed(e.getMsg());
    }
}