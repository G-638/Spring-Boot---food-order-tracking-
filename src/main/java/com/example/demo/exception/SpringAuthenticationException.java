package com.example.demo.exception;


public class SpringAuthenticationException extends RuntimeException{

    public ErrorMessages message;

    public enum ErrorMessages{INCORRECT_PASSWORD, INVALID_USERNAME, INCORRECT_USERNAME, INVALID_PASSWORD, USERNAME_NOT_FOUND, USER_ALREADY_PRESENT, INCORRECT_USERNAME_OR_PASSWORD};

    public SpringAuthenticationException(ErrorMessages message){
        this.message = message;
    }

    public int getErrorCode(){
        switch (message){
            case INCORRECT_PASSWORD:
                return 0;
            case INVALID_USERNAME:
                return 1;
            case INCORRECT_USERNAME:
                return 2;
            case INVALID_PASSWORD:
                return 3;
            case USERNAME_NOT_FOUND:
                return 4;
            case INCORRECT_USERNAME_OR_PASSWORD:
                return 5;
            default:
                return -1;
        }
    }


    public String getMessage() {
        return message.name();
    }
}


