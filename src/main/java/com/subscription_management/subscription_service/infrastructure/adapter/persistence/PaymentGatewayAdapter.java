package com.subscription_management.subscription_service.infrastructure.adapter.persistence;

import com.subscription_management.subscription_service.core.port.PaymentGatewayPort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentGatewayAdapter implements PaymentGatewayPort {
    @Override
    public boolean charge(BigDecimal amount, String customerId, String paymentMethod) {
        return false;
    }
}
