package com.subscription_management.subscription_service.core.domain.exception;

public class SubscriptionNotFoundException extends RuntimeException{
    public SubscriptionNotFoundException(Long id) {
        super("Subscription with ID " + id + " not found");
    }
}
