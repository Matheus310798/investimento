package com.projetc.investimento.Exception;

import org.springframework.http.HttpStatus;

public class DefaultException extends RuntimeException{

    private HttpStatus status;

    public DefaultException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
