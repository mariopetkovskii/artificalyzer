package com.artificalyzer.models.userroles.exceptions;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(Long id) {
        super("Role with id %d was not found");
    }
}
