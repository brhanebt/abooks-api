package com.abooksapimvn.abooks.exception;

import java.io.Serial;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
public class NotFoundException extends RuntimeException{
    @Serial
    private final long serialVersionUID = 2L;

    private Long objIdentifier;

    public NotFoundException(Long id){
        super("Error with "+ id);
    }

    public <T> NotFoundException(Class<T> cls){
        super("table for "+ cls.getSimpleName()+ " is empty");
    }

    public <T> NotFoundException(Class<T> cls, Long id){
        super(cls.getSimpleName() + " with id " + id + " not found");
        this.objIdentifier = id;
    }

    public Long getObjIdentifier(){
        return objIdentifier;
    }

}
