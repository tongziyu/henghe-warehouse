package com.ian.exception;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/18 00:31
 */
public class ProductException extends RuntimeException{
    public ProductException() {
        super();
    }

    public ProductException(String message) {
        super(message);
    }
}
