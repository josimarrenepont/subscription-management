package com.subscription_management.subscription_service.core.port;

import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.core.domain.Subscription;

public interface NotificationPort {
    void sendSubscriptionCreated(Subscription subscription);
    void sendSubscriptionCancelled(Subscription subscription);
    void sendPaymentFailed(Subscription subscription);
}
