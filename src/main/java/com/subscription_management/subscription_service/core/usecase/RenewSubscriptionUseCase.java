package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.core.domain.exception.InvalidSubscriptionOperationException;
import com.subscription_management.subscription_service.core.domain.exception.SubscriptionNotFoundException;
import com.subscription_management.subscription_service.core.port.PaymentGatewayPort;
import com.subscription_management.subscription_service.core.port.SubscriptionStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.RenewSubscriptionCommand;
import com.subscription_management.subscription_service.core.usecase.model.SubscriptionResponse;

public class RenewSubscriptionUseCase {

    private final SubscriptionStoragePort subscriptionStorage;
    private final PaymentGatewayPort paymentGateway;

    public RenewSubscriptionUseCase(SubscriptionStoragePort subscriptionStorage, PaymentGatewayPort paymentGateway) {
        this.subscriptionStorage = subscriptionStorage;
        this.paymentGateway = paymentGateway;
    }

    public SubscriptionResponse execute(RenewSubscriptionCommand command){
        Subscription subscription = subscriptionStorage.findById(command.subscriptionId())
                .orElseThrow(() -> new SubscriptionNotFoundException(command.subscriptionId()));

        boolean paymentSuccess = paymentGateway.charge(
                subscription.getPlan().getPrice(),
                subscription.getCustomer().getId().toString(),
                subscription.getPaymentMethod()
        );

        if(!paymentSuccess){
            throw new InvalidSubscriptionOperationException("Payment falied for renewal");
        }

        subscription.renew(subscription.getPlan().getPrice());

        Subscription saved = subscriptionStorage.save(subscription);

        return SubscriptionResponse.fromDomain(saved);
    }
}
