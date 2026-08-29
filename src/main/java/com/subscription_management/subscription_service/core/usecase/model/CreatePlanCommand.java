package com.subscription_management.subscription_service.core.usecase.model;

import com.subscription_management.subscription_service.core.domain.PlanType;
import com.subscription_management.subscription_service.core.domain.exception.InvalidPlanDataException;

import java.math.BigDecimal;

public record CreatePlanCommand(
        String name,
        String description,
        PlanType type,
        BigDecimal price,
        int durationMonths
) {
    public CreatePlanCommand{
        if(name == null || name.isBlank()){
            throw new InvalidPlanDataException("Plan name is required");
        }
        if(price == null || price.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidPlanDataException("Price must be greater than zero");
        }
        if(durationMonths <= 0){
            throw new InvalidPlanDataException("Duration must be greater than zero");
        }
    }
}
