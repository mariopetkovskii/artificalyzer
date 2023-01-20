package com.artificalyzer.models.userroles.exceptions;

public class PasswordNotValidException extends RuntimeException{
    public PasswordNotValidException() {
        super("Password is not valid");
    }
}
