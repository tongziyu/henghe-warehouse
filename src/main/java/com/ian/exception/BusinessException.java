package com.ian.exception;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/15 17:31
 */
public class BusinessException extends RuntimeException{
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }
}
