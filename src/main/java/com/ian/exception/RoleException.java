package com.ian.exception;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 18:59
 */
public class RoleException extends RuntimeException{
    public RoleException() {
        super();
    }

    public RoleException(String message) {
        super(message);
    }
}
