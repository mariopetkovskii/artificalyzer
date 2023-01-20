package com.artificalyzer.models.userroles.exceptions;

public class UserNotEnabledException extends RuntimeException{
    public UserNotEnabledException() {
        super("Account is not enabled");
    }
}
