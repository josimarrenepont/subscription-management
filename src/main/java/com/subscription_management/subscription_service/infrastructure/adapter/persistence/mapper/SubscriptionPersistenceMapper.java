package com.subscription_management.subscription_service.infrastructure.adapter.persistence.mapper;

import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.CustomerEntity;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.PlanEntity;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.SubscriptionEntity;

public class SubscriptionPersistenceMapper {

    public static SubscriptionEntity toEntity(Subscription domain, CustomerEntity customerEntity, PlanEntity planEntity) {
        return new SubscriptionEntity(
                domain.getId(),
                planEntity,
                customerEntity,
                domain.getStatus(),
                domain.getStartDate(),
                domain.getEndDate(),
                domain.getNextBillingDate(),
                domain.getLastPaymentAmount(),
                domain.getPaymentMethod()
        );
    }

    public static Subscription toDomain(SubscriptionEntity entity) {
        return new Subscription(
                entity.getId(),
                CustomerPersistenceMapper.toDomain(entity.getCustomer()),
                PlanPersistenceMapper.toDomain(entity.getPlan()),
                entity.getStatus(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getNextBillingDate(),
                entity.getLastPaymentAmount(),
                entity.getPaymentMethod()
        );
    }
}