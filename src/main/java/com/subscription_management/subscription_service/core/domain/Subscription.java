package com.subscription_management.subscription_service.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Subscription {

    private final Long id;
    private LocalDateTime endTime;
    private LocalDateTime nextBillingDate;
    private BigDecimal lastPaymentAmount;
    private String paymentMethod;

    public Subscription(Long id) {
        this.id = id;
    }
}
