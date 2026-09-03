package com.subscription_management.subscription_service.infrastructure.adapter.persistence;

import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.core.port.NotificationPort;
import org.springframework.stereotype.Component;

@Component
public class NotificationStorageAdapter implements NotificationPort {
    @Override
    public void sendSubscriptionCreated(Subscription subscription) {

    }

    @Override
    public void sendSubscriptionCancelled(Subscription subscription) {

    }

    @Override
    public void sendPaymentFailed(Subscription subscription) {

    }
}
