package com.subscription_management.subscription_service.core.domain.exception;

public class PlanAlreadyExistsException extends RuntimeException{
    public PlanAlreadyExistsException(String name){
        super("Plan with name '" + name + "' already exists");
    }
}
