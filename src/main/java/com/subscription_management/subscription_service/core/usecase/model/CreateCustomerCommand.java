package com.subscription_management.subscription_service.core.usecase.model;

public record CreateCustomerCommand(
        String name,
        String email,
        String document

) {
    public CreateCustomerCommand{
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name is required");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (document == null || document.isBlank()) {
            throw new IllegalArgumentException("Document is required");
        }
    }
}
