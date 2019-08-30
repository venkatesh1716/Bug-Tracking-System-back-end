package com.tmt.bugreviewsystem.brs.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsertIdExc extends RuntimeException {
    public InsertIdExc(String message) {
        super(message);
    }

}
