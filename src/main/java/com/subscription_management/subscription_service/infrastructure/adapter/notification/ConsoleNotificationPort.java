package com.subscription_management.subscription_service.infrastructure.adapter.notification;

import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.core.port.NotificationPort;

public class ConsoleNotificationPort implements NotificationPort {
    @Override
    public void sendSubscriptionCreated(Subscription subscription) {
        System.out.println("Subscription created for customer: " + subscription.getCustomer()
                .getName());
        System.out.println("Plan: " + subscription.getPlan().getName());
        System.out.println("Start: " + subscription.getStartDate());
        System.out.println("End: " + subscription.getEndDate());
    }

    @Override
    public void sendSubscriptionCancelled(Subscription subscription) {
        System.out.println("Subscriptyon cancelled for customer: "
                + subscription.getCustomer().getName());
    }

    @Override
    public void sendPaymentFailed(Subscription subscription) {
        System.out.println("Payment failed for subscription: "
                + subscription.getId());
    }
}
