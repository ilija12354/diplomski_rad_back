package com.diplomski.obavestavanje.nastavnika.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID=1L;

    public ResourceNotFoundException(String arg0) {
        super(arg0);
    }
}
