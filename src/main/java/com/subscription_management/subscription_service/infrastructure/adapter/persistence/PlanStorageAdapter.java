package com.subscription_management.subscription_service.infrastructure.adapter.persistence;

import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.core.port.PlanStoragePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlanStorageAdapter implements PlanStoragePort {
    @Override
    public Plan save(Plan plan) {
        return null;
    }

    @Override
    public Optional<Plan> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }

    @Override
    public List<Plan> findAll() {
        return List.of();
    }
}
