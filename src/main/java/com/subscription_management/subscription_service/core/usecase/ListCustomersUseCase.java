package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.port.CustomerStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.CustomerResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ListCustomersUseCase {

    private final CustomerStoragePort customerPort;

    public ListCustomersUseCase(CustomerStoragePort customerPort) {
        this.customerPort = customerPort;
    }

    public List<CustomerResponse> execute(){
        return customerPort.findAll()
                .stream().map(CustomerResponse::fromDomain)
                .collect(Collectors.toList());
    }
}
