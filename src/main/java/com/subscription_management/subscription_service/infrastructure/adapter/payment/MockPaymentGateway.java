package com.subscription_management.subscription_service.infrastructure.adapter.payment;

import com.subscription_management.subscription_service.core.port.PaymentGatewayPort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class MockPaymentGateway {

    private final List<String> validPaymentMethods = List.of(
            "CREDIT_CARD", "DEBIT_CARD", "PIX", "BOLETO", "PAYPAL"
    );

    public boolean charge(BigDecimal amount, String customerId, String paymentMethod) {
        System.out.println("💰 Processing payment...");
        System.out.println("   Amount: R$ " + amount);
        System.out.println("   Customer: " + customerId);
        System.out.println("   Payment Method: " + paymentMethod);

        if(paymentMethod == null || paymentMethod.isBlank()){
            System.out.println("❌ Payment method is required");
            return false;
        }

        boolean isValidMethod = validPaymentMethods.stream().anyMatch(
                method -> method.equalsIgnoreCase(paymentMethod)
        );

        if (!isValidMethod) {
            System.out.println("❌ Invalid payment method: " + paymentMethod);
            System.out.println("   Valid methods: " + validPaymentMethods);
            return false;
        }

        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("❌ Invalid amount: " + amount);
            return false;
        }

        System.out.println("✅ Payment approved!");
        return true;
    }
}
