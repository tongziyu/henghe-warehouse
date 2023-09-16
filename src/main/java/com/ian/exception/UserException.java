package com.ian.exception;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 02:09
 */
public class UserException extends RuntimeException{
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }
}
