package com.subscription_management.subscription_service.core.usecase.model;

import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.core.domain.SubscriptionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SubscriptionResponse(
        Long id,
        Long customerId,
        Long planId,
        SubscriptionStatus status,
        LocalDateTime startDate,
        LocalDateTime endDate,
        LocalDateTime nextBillingDate,
        BigDecimal lastPaymentAmount
) {
    public static SubscriptionResponse fromDomain(Subscription subscription){
        return new SubscriptionResponse(
                subscription.getId(),
                subscription.getCustomer().getId(),
                subscription.getPlan().getId(),
                subscription.getStatus(),
                subscription.getStartDate(),
                subscription.getEndDate(),
                subscription.getNextBillingDate(),
                subscription.getLastPaymentAmount()
        );
    }
}
