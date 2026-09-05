package com.subscription_management.subscription_service.infrastructure.adapter.payment;

import com.subscription_management.subscription_service.core.port.PaymentGatewayPort;

import java.math.BigDecimal;

public class MockPaymentGateway implements PaymentGatewayPort {

    @Override
    public boolean charge(BigDecimal amount, String customerId, String paymentMethod) {
        System.out.println("Processing payment of R$ " + amount + " for customer " + customerId +
                " using " + paymentMethod);

        return true;
    }
}
