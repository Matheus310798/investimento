package com.projetc.investimento.Exception;

import org.springframework.http.HttpStatus;

public class DefaultErrorDTO {
    private String message;
    private Integer status;

    public DefaultErrorDTO(String message){
        this.message = message;
    }
    public DefaultErrorDTO(String message, HttpStatus status){
        this.message = message;
        this.status = status.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }
}
