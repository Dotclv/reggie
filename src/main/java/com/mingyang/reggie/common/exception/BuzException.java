package com.mingyang.reggie.common.exception;

import com.mingyang.reggie.common.result.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 36995
 */
public class BuzException extends RuntimeException {
    private static final long serialVersionUID = -4060113353672728550L;
    private final Integer code;

    public BuzException(String message) {
        super(message);
        this.code = ResultCode.INTERFACE_INVOKE_FAILED.code();
    }

    public BuzException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BuzException(ResultCode resultCode) {
        super(resultCode.message());
        this.code = resultCode.code();
    }

    @Override
    public String toString() {
        return "BuzException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}