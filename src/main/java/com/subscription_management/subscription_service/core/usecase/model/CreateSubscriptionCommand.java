package com.subscription_management.subscription_service.core.usecase.model;

public record CreateSubscriptionCommand(
        Long customerId,
        Long planId,
        String paymentMethod

) {
    public CreateSubscriptionCommand{
        if(customerId == null){
            throw new IllegalArgumentException("Customer Id is required");
        }
        if(planId == null){
            throw new IllegalArgumentException("Plan Id is required");
        }
        if(paymentMethod == null || paymentMethod.isBlank()){
            throw new IllegalArgumentException("Payment method is required");
        }
    }
}
