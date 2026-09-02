package com.subscription_management.subscription_service.entrypoint.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.subscription_management.subscription_service.core.domain.SubscriptionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SubscriptionResponseDTO(
        Long id,
        Long customerId,
        Long planId,
        SubscriptionStatus status,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        LocalDateTime startDate,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        LocalDateTime endDate,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        LocalDateTime nextBillingDate,

        BigDecimal lastPaymentAmount,
        String paymentMethod
) {
}
