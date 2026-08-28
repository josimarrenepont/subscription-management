package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.core.domain.exception.SubscriptionNotFoundException;
import com.subscription_management.subscription_service.core.port.NotificationPort;
import com.subscription_management.subscription_service.core.port.SubscriptionStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.CancelSubscriptionCommand;
import com.subscription_management.subscription_service.core.usecase.model.SubscriptionResponse;

public class CancelSubscriptionUseCase {

    private final SubscriptionStoragePort subscriptionStorage;
    private final NotificationPort notification;


    public CancelSubscriptionUseCase(SubscriptionStoragePort subscriptionStorage, NotificationPort notification) {
        this.subscriptionStorage = subscriptionStorage;
        this.notification = notification;
    }

    public SubscriptionResponse execute(CancelSubscriptionCommand command){
        Subscription subscription = subscriptionStorage.findById(command.subscriptionId())
                .orElseThrow(() -> new SubscriptionNotFoundException(command.subscriptionId()));

        subscription.cancel();

        Subscription saved = subscriptionStorage.save(subscription);

        notification.sendSubscriptionCancelled(saved);

        return SubscriptionResponse.fromDomain(saved);
    }
}
