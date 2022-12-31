package com.dolts.springcommerce.services.exceptions;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public DatabaseException(String msg) {
        super(msg);
    }
}
