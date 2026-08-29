package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Customer;
import com.subscription_management.subscription_service.core.domain.exception.CustomerNotFoundException;
import com.subscription_management.subscription_service.core.port.CustomerStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.CustomerResponse;

public class FindCustomerUseCase {

    private final CustomerStoragePort customerPort;

    public FindCustomerUseCase(CustomerStoragePort customerPort) {
        this.customerPort = customerPort;
    }

    public CustomerResponse execute(Long customerId){

        Customer customer = customerPort.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        return CustomerResponse.fromDomain(customer);
    }
}
