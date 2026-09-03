package com.subscription_management.subscription_service.infrastructure.config;

import com.subscription_management.subscription_service.core.port.*;
import com.subscription_management.subscription_service.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerStoragePort customerStorage){
        return new CreateCustomerUseCase(customerStorage);
    }
    @Bean
    public CreatePlanUseCase createPlanUseCase(PlanStoragePort planStorage){
        return new CreatePlanUseCase(planStorage);
    }
    @Bean
    public CreateSubscriptionUseCase
    createSubscriptionUseCase(
            SubscriptionStoragePort subscriptionStorage,
            NotificationPort notification, CustomerStoragePort customerStorage,
            PaymentGatewayPort gatewayPort, PlanStoragePort planPort){
        return new CreateSubscriptionUseCase
                (subscriptionStorage, notification, customerStorage, gatewayPort, planPort);
    }
    @Bean
    public FindCustomerUseCase findCustomerUseCase(CustomerStoragePort customerStorage){
        return new FindCustomerUseCase(customerStorage);
    }
    @Bean
    public FindPlanUseCase findPlanUseCase(PlanStoragePort planPort){
        return new FindPlanUseCase(planPort);
    }
    @Bean
    public FindSubscriptionUseCase findSubscriptionUseCase(SubscriptionStoragePort subscriptionStorage){
        return new FindSubscriptionUseCase(subscriptionStorage);
    }
    @Bean
    public ListCustomersUseCase listCustomersUseCase(CustomerStoragePort customerStorage){
        return new ListCustomersUseCase(customerStorage);
    }
    @Bean
    public ListPlanUseCase listPlanUseCase(PlanStoragePort planPort){
        return new ListPlanUseCase(planPort);
    }
    @Bean
    public RenewSubscriptionUseCase renewSubscriptionUseCase(SubscriptionStoragePort subscriptionStorage,
                                                              PaymentGatewayPort gatewayPort){
        return new RenewSubscriptionUseCase(subscriptionStorage, gatewayPort);
    }
    @Bean
    public CancelSubscriptionUseCase cancelSubscriptionUseCase(SubscriptionStoragePort subscriptionStorage,
                                                               NotificationPort notification){
        return new CancelSubscriptionUseCase(subscriptionStorage, notification);
    }
}
