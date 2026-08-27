package com.subscription_management.subscription_service.core.domain.exception;

public class InvalidSubscriptionOperationException extends RuntimeException{
    public InvalidSubscriptionOperationException(String message){
        super(message);
    }
    public InvalidSubscriptionOperationException(String messsage, Throwable cause){
        super(messsage, cause);
    }
}
