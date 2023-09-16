package com.ian.handler;

import com.ian.exception.UserException;
import com.ian.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 02:08
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public Result userExceptionHandler(Exception e){

        return Result.err(Result.CODE_ERR_BUSINESS,e.getMessage());
    }
}
