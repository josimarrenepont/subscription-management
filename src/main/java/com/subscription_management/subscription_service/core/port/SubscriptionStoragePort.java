package com.subscription_management.subscription_service.core.port;

import com.subscription_management.subscription_service.core.domain.Subscription;

import java.util.Optional;

public interface SubscriptionStoragePort {
    Subscription save(Subscription subscription);
    Optional<Subscription> findById(Long id);
    void delete(Long id);
}
