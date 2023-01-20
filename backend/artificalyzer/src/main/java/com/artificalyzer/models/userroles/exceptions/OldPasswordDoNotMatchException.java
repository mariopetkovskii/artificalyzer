package com.artificalyzer.models.userroles.exceptions;

public class OldPasswordDoNotMatchException extends RuntimeException{
    public OldPasswordDoNotMatchException() {
        super("Old password do not match");
    }
}
