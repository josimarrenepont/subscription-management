package com.subscription_management.subscription_service.core.usecase.model;

import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.core.domain.PlanType;

import java.math.BigDecimal;

public record PlanResponse(
        Long id,
        String name,
        String description,
        PlanType type,
        BigDecimal price,
        int durationMonths
) {
    public static PlanResponse fromDomain(Plan plan){
        return new PlanResponse(
                plan.getId(),
                plan.getName(),
                plan.getDescription(),
                plan.getType(),
                plan.getPrice(),
                plan.getDurationMonths()
        );
    }
}
