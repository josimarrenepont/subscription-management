package com.subscription_management.subscription_service.core.domain.exception;

public class PlanNotFoundException extends RuntimeException{
    public PlanNotFoundException(Long id){
        super("Plan not found id" + id);
    }
}
