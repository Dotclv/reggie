package com.mingyang.reggie.common.exception;


import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.common.result.ResultCode;
import com.mingyang.reggie.common.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.SQLIntegrityConstraintViolationException;

import static com.mingyang.reggie.common.result.Result.failure;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**-------- 指定异常处理方法 --------**/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result error(NullPointerException e) {
        log.error(ExceptionUtil.getMessage(e));
        return failure(ResultCode.PARAM_IS_EMPTY);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Result error(IndexOutOfBoundsException e) {
        log.error(ExceptionUtil.getMessage(e));
        return failure(ResultCode.NOT_FOUND);
    }

    /**-------- 自定义定异常处理方法 --------**/
    @ExceptionHandler(BuzException.class)
    @ResponseBody
    public Result error(BuzException e) {
        log.error(ExceptionUtil.getMessage(e));
        return failure(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public Result error(SQLIntegrityConstraintViolationException e) {
        log.error(ExceptionUtil.getMessage(e));
        if(e.getMessage().contains("Duplicate entry")){
            String[] s = e.getMessage().split(" ");
            return failure(ResultCode.PARAM_IS_EMPTY,s[2]+"已存在");
        }
        return failure(ResultCode.PARAM_ERROR);
    }

    /**-------- 通用异常处理方法 --------**/
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Result error(Exception e) {
//        log.error(ExceptionUtil.getMessage(e));
//        return failure(ResultCode.INTERNAL_SERVER_ERROR);
//    }
}