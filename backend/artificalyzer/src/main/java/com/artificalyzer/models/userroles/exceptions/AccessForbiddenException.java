package com.artificalyzer.models.userroles.exceptions;

public class AccessForbiddenException extends RuntimeException{
    public AccessForbiddenException() {
        super("Access forbidden");
    }
}
