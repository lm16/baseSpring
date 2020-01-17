package com.lm16.uo.config.exception;

public class BaseException extends RuntimeException{

    public BaseException(){

    }

    public BaseException(String message){
        super(message);
    }

}
