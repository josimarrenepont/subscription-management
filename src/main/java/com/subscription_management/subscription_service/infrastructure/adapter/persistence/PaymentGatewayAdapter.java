package com.subscription_management.subscription_service.infrastructure.adapter.persistence;

import com.subscription_management.subscription_service.core.port.PaymentGatewayPort;
import com.subscription_management.subscription_service.infrastructure.adapter.payment.MockPaymentGateway;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentGatewayAdapter implements PaymentGatewayPort {

    private final MockPaymentGateway paymentGateway;

    public PaymentGatewayAdapter(MockPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public boolean charge(BigDecimal amount, String customerId, String paymentMethod) {
        return paymentGateway.charge(amount, customerId, paymentMethod);
    }
}
