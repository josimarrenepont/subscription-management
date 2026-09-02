package com.subscription_management.subscription_service.entrypoint.dto;

public record SubscriptionRequestDTO(

        Long customerId,
        Long planId,
        String paymentMethod
) {
}
