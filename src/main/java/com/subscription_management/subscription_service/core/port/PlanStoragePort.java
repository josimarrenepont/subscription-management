package com.subscription_management.subscription_service.core.port;

import com.subscription_management.subscription_service.core.domain.Plan;

import java.util.Optional;

public interface PlanStoragePort {
    Plan save(Plan plan);
    Optional<Plan> findById(Long id);
    void delete(Long id);
}
