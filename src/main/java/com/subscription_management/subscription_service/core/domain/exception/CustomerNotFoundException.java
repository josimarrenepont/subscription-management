package com.subscription_management.subscription_service.core.domain.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Long id){
        super("Customer not found with ID: " + id);
    }
}
