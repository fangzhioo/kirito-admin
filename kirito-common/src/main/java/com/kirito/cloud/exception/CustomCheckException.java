package com.kirito.cloud.exception;

import lombok.Builder;
import lombok.Data;

/**
 * @author fz
 * 参数校验抛出的自定义异常
 *
 * 值得注意的是，当抛出的异常继承自Exception时，需要在全局异常处理中生效，需要一直抛出到controller层；
 * 但是如果继承自RuntimeException时，则不需要一直throws到controller
 */
@Data
@Builder
public class CustomCheckException extends RuntimeException {

    private String msg;

    public CustomCheckException(String msg) {
        super(msg);
        this.msg = msg;
    }
}