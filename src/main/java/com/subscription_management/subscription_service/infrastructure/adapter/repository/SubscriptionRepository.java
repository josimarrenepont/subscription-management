package com.subscription_management.subscription_service.infrastructure.adapter.repository;

import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
}
