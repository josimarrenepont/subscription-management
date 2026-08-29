package com.subscription_management.subscription_service.core.domain.exception;

public class InvalidPlanDataException extends RuntimeException{
    public InvalidPlanDataException(String message){
        super(message);
    }
}
