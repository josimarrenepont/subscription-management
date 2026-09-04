package com.subscription_management.subscription_service.infrastructure.adapter.persistence;

import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.core.port.SubscriptionStoragePort;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.CustomerEntity;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.PlanEntity;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.mapper.SubscriptionPersistenceMapper;
import com.subscription_management.subscription_service.infrastructure.adapter.repository.CustomerRepository;
import com.subscription_management.subscription_service.infrastructure.adapter.repository.PlanRepository;
import com.subscription_management.subscription_service.infrastructure.adapter.repository.SubscriptionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubscriptionStorageAdapter implements SubscriptionStoragePort {

    private final SubscriptionRepository subscriptionRepository;
    private final CustomerRepository customerRepository;
    private final PlanRepository planRepository;

    public SubscriptionStorageAdapter(SubscriptionRepository subscriptionRepository, CustomerRepository customerRepository, PlanRepository planRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.customerRepository = customerRepository;
        this.planRepository = planRepository;
    }

    @Override
    public Subscription save(Subscription subscription) {
        CustomerEntity customerEntity = customerRepository.findById(subscription.getCustomer().getId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        PlanEntity planEntity = planRepository.findById(subscription.getPlan().getId())
                .orElseThrow(() -> new IllegalArgumentException("Plan not found"));

        var entityToSave = SubscriptionPersistenceMapper.toEntity(subscription, customerEntity, planEntity);
        var savedEntity = subscriptionRepository.save(entityToSave);

        return SubscriptionPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Subscription> findById(Long id) {
        return subscriptionRepository.findById(id)
                .map(SubscriptionPersistenceMapper::toDomain);
    }

    @Override
    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
