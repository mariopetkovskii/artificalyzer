package com.artificalyzer.models.userroles.exceptions;

public class MailNotValidException extends RuntimeException{
    public MailNotValidException() {
        super("Mail is not valid");
    }
}
