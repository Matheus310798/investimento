package com.projetc.investimento.Model.DTO;

import org.springframework.http.HttpStatus;

public class ErrorDTO {
    private String message;
    private Integer status;

    public ErrorDTO(String message){
        this.message = message;
    }
    public ErrorDTO(String message, HttpStatus status){
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
