package com.atelier.tenisu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MethodArgumentException extends RuntimeException {
    public MethodArgumentException(String message){
        super(message);
    }

}
