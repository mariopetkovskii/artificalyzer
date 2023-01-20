package com.artificalyzer.models.userroles.exceptions;

public class RoleAlreadyExistsException extends RuntimeException{
    public RoleAlreadyExistsException() {
        super("Role already exists exception");
    }
}
