package com.subscription_management.subscription_service.infrastructure.adapter.persistence.mapper;

import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.PlanEntity;

public class PlanPersistenceMapper {
    public static PlanEntity toEntity(Plan domain){
        if(domain == null) return null;
        return new PlanEntity(
                domain.getId(),
                domain.getName(),
                domain.getDescription(),
                domain.getType(),
                domain.getPrice(),
                domain.getDurationMonths()
        );
    }

    public static Plan toDomain(PlanEntity entity){
        if(entity == null) return null;
        return new Plan(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getType(),
                entity.getPrice(),
                entity.getDurationMonths()
        );
    }
}
