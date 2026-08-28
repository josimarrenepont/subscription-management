package com.subscription_management.subscription_service.core.port;

import java.math.BigDecimal;

public interface PaymentGatewayPort {
    boolean charge(BigDecimal amount, String customerId, String paymentMethod);
}
