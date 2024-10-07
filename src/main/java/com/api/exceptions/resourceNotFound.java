package com.api.exceptions;

public class resourceNotFound extends RuntimeException{
    public resourceNotFound(String msg) {
        super(msg);
    }
}
