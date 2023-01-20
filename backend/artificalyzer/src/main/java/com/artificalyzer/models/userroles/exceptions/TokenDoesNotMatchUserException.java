package com.artificalyzer.models.userroles.exceptions;

public class TokenDoesNotMatchUserException extends RuntimeException{
    public TokenDoesNotMatchUserException() {
        super("Token doesn't match user");
    }
}
