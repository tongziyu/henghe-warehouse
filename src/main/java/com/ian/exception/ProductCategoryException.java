package com.ian.exception;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/18 20:12
 */
public class ProductCategoryException extends RuntimeException{
    public ProductCategoryException() {
        super();
    }

    public ProductCategoryException(String message) {
        super(message);
    }
}
