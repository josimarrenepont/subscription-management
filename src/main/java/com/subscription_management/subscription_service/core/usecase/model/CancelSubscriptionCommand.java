package com.subscription_management.subscription_service.core.usecase.model;

public record CancelSubscriptionCommand(
        Long subscriptionId
) {
    public CancelSubscriptionCommand {
        if(subscriptionId == null){
            throw new IllegalArgumentException("Subscription ID is required");
        }
    }
}
