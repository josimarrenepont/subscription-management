package com.subscription_management.subscription_service.infrastructure.adapter.persistence;

import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.core.port.PlanStoragePort;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.PlanEntity;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.mapper.PlanPersistenceMapper;
import com.subscription_management.subscription_service.infrastructure.adapter.repository.PlanRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlanStorageAdapter implements PlanStoragePort {

    private final PlanRepository planRepository;

    public PlanStorageAdapter(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }


    @Override
    public Plan save(Plan plan) {
        var entityToSave = PlanPersistenceMapper.toEntity(plan);

        var savedEntity = planRepository.save(entityToSave);

        return PlanPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id).map(PlanPersistenceMapper::toDomain);
    }

    @Override
    public void delete(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return planRepository.existsByName(name);
    }

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll()
                .stream().map(PlanPersistenceMapper::toDomain).toList();
    }
}
