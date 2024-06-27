package com.projetc.investimento.Handler;

import com.projetc.investimento.Exception.DefaultException;
import com.projetc.investimento.Exception.TagNotFoundException;
import com.projetc.investimento.Exception.UnathorizesException;
import com.projetc.investimento.Model.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(TagNotFoundException.class)
    public ErrorDTO handler(TagNotFoundException ex){
        return new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    @ExceptionHandler(UnathorizesException.class)
    public ErrorDTO handler(UnathorizesException ex){
        return new ErrorDTO(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<ErrorDTO> handler(DefaultException ex){
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), ex.getStatus());
        HttpStatus httpStatus = HttpStatus.valueOf(ex.getStatus().value());
        return new ResponseEntity<ErrorDTO>(errorDTO, httpStatus);
    }

}
