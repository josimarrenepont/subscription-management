package com.subscription_management.subscription_service.entrypoint.dto;

import com.subscription_management.subscription_service.core.domain.PlanType;

import java.math.BigDecimal;

public record PlanResponseDTO(
        Long id,
        String name,
        String description,
        PlanType type,
        BigDecimal price,
        int durationMonths
) {
}
