package com.neobis.week6.exception;

import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends RuntimeException {
    final HttpStatus NOT_FOUND_STATUS = HttpStatus.NOT_FOUND;

    public HttpStatus getNOT_FOUND_STATUS() {
        return NOT_FOUND_STATUS;
    }

    public ClientNotFoundException(Long id) {
        super("Could not find client " + id);
    }
}
