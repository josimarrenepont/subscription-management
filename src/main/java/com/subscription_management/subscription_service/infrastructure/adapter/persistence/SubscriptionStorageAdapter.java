package com.subscription_management.subscription_service.infrastructure.adapter.persistence;

import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.core.port.SubscriptionStoragePort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubscriptionStorageAdapter implements SubscriptionStoragePort {

    @Override
    public Subscription save(Subscription subscription) {
        return null;
    }

    @Override
    public Optional<Subscription> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
