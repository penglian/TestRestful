package com.example.administrator.testrestful.pl.download;

/**
 * 自定义异常
 * Created by pl on 16/7/5.
 */
public class CustomizeException extends RuntimeException {

    public CustomizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
