package com.example.demo.exception;

public class CustomException extends RuntimeException{
    public enum ErrorMessage{EMPTY_LIST}
    private final ErrorMessage error;
    public CustomException(ErrorMessage err){
        this.error = err;
    }

    public ErrorMessage getError() {
        return error;
    }

    public int getErrorCode(){
        return -1;
    }

}
