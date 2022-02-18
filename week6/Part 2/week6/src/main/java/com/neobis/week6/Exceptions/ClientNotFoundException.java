package com.neobis.week6.Exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
