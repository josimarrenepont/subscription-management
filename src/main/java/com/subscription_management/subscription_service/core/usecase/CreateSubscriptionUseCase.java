package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Customer;
import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.core.domain.Subscription;
import com.subscription_management.subscription_service.core.domain.exception.CustomerNotFoundException;
import com.subscription_management.subscription_service.core.domain.exception.InvalidSubscriptionOperationException;
import com.subscription_management.subscription_service.core.domain.exception.PlanNotFoundException;
import com.subscription_management.subscription_service.core.port.*;
import com.subscription_management.subscription_service.core.usecase.model.CreateSubscriptionCommand;
import com.subscription_management.subscription_service.core.usecase.model.SubscriptionResponse;

public class CreateSubscriptionUseCase {

    private final SubscriptionStoragePort subscriptionStorage;
    private final NotificationPort notification;
    private final CustomerStoragePort customerStorage;
    private final PaymentGatewayPort paymentGateway;
    private final PlanStoragePort planPort;

    public CreateSubscriptionUseCase(SubscriptionStoragePort subscriptionStorage,
                                     NotificationPort notification, CustomerStoragePort customerStorage,
                                     PaymentGatewayPort paymentGateway, PlanStoragePort planPort) {
        this.subscriptionStorage = subscriptionStorage;
        this.notification = notification;
        this.customerStorage = customerStorage;
        this.paymentGateway = paymentGateway;
        this.planPort = planPort;
    }

    public SubscriptionResponse execute(CreateSubscriptionCommand command){
        Customer customer = customerStorage.findById(command.customerId())
                .orElseThrow(() -> new CustomerNotFoundException(command.customerId()));

        Plan plan = planPort.findById(command.planId())
                .orElseThrow(() -> new PlanNotFoundException(command.planId()));

        Subscription subscription = new Subscription(customer, plan);

        boolean paymentSuccess = paymentGateway.charge(
                plan.getPrice(),
                customer.getId().toString(),
                command.paymentMethod()
        );

        if(!paymentSuccess){
            notification.sendPaymentFailed(subscription);
            throw new InvalidSubscriptionOperationException("Payment failed");
        }

        Subscription saved = subscriptionStorage.save(subscription);

        notification.sendSubscriptionCreated(saved);

        return SubscriptionResponse.fromDomain(saved);
    }

}
