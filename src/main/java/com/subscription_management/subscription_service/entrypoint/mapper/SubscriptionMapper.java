package com.subscription_management.subscription_service.entrypoint.mapper;

import com.subscription_management.subscription_service.core.usecase.model.CreateSubscriptionCommand;
import com.subscription_management.subscription_service.core.usecase.model.SubscriptionResponse;
import com.subscription_management.subscription_service.entrypoint.dto.SubscriptionRequestDTO;
import com.subscription_management.subscription_service.entrypoint.dto.SubscriptionResponseDTO;

public class SubscriptionMapper {

    public static CreateSubscriptionCommand toCommand(SubscriptionRequestDTO request){
        return new CreateSubscriptionCommand(
                request.customerId(),
                request.planId(),
                request.paymentMethod()
        );
    }

    public static SubscriptionResponseDTO toDTO(SubscriptionResponse response) {
        return new SubscriptionResponseDTO(
                response.id(),
                response.customerId(),
                response.planId(),
                response.status(),
                response.startDate(),
                response.endDate(),
                response.nextBillingDate(),
                response.lastPaymentAmount(),
                response.paymentMethod()
        );
    }
}
