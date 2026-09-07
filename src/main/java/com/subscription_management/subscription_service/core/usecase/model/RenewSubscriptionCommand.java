package com.subscription_management.subscription_service.core.usecase.model;

public record RenewSubscriptionCommand(Long subscriptionId) {
    public RenewSubscriptionCommand{
        if(subscriptionId == null){
            throw new IllegalArgumentException("Subscription ID is required");
        }
    }
}
