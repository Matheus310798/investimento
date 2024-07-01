package com.projetc.investimento.Handler;

import com.projetc.investimento.Exception.DefaultException;
import com.projetc.investimento.Exception.ExistException;
import com.projetc.investimento.Exception.NotFoundException;
import com.projetc.investimento.Exception.UnathorizeException;
import com.projetc.investimento.Exception.DefaultErrorDTO;
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
    @ExceptionHandler(NotFoundException.class)
    public DefaultErrorDTO handler(NotFoundException ex){
        return new DefaultErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(ExistException.class)
    public DefaultErrorDTO handler(ExistException ex){
        return new DefaultErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    @ExceptionHandler(UnathorizeException.class)
    public DefaultErrorDTO handler(UnathorizeException ex){
        return new DefaultErrorDTO(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<DefaultErrorDTO> handler(DefaultException ex){
        DefaultErrorDTO defaultErrorDTO = new DefaultErrorDTO(ex.getMessage(), ex.getStatus());
        HttpStatus httpStatus = HttpStatus.valueOf(ex.getStatus().value());
        return new ResponseEntity<DefaultErrorDTO>(defaultErrorDTO, httpStatus);
    }

}
