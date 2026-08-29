package com.subscription_management.subscription_service.core.usecase.model;

import com.subscription_management.subscription_service.core.domain.Customer;

public record CustomerResponse(
        Long id,
        String name,
        String email,
        String document
) {
    public static CustomerResponse fromDomain(Customer customer){
        return new CustomerResponse (
                customer.getId(),
                customer.getEmail(),
                customer.getName(),
                customer.getDocument()
        );
    }
}
