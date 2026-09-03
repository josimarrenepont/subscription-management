package com.subscription_management.subscription_service.infrastructure.adapter.repository;

import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
}
