package com.subscription_management.subscription_service.core.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String email){
        super("Email with name '" + email + "' already exists");
    }
}
