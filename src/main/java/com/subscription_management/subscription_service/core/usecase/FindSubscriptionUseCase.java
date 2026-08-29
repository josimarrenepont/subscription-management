package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.core.domain.exception.SubscriptionNotFoundException;
import com.subscription_management.subscription_service.core.port.SubscriptionStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.SubscriptionResponse;

public class FindSubscriptionUseCase {

    private final SubscriptionStoragePort subscriptionStorage;


    public FindSubscriptionUseCase(SubscriptionStoragePort subscriptionStorage) {
        this.subscriptionStorage = subscriptionStorage;
    }

    public SubscriptionResponse execute(Long subscriptionId){
        Subscription subscription = subscriptionStorage.findById(subscriptionId)
                .orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));

        return SubscriptionResponse.fromDomain(subscription);
    }
}
