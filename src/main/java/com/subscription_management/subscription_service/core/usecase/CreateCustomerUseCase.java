package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Customer;
import com.subscription_management.subscription_service.core.domain.exception.EmailAlreadyExistsException;
import com.subscription_management.subscription_service.core.port.CustomerStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.CreateCustomerCommand;
import com.subscription_management.subscription_service.core.usecase.model.CustomerResponse;

public class CreateCustomerUseCase {

    private final CustomerStoragePort customerPort;

    public CreateCustomerUseCase(CustomerStoragePort customerPort) {
        this.customerPort = customerPort;
    }

    public CustomerResponse execute(CreateCustomerCommand command){

        if(customerPort.existsByEmail(command.email())){
            throw new EmailAlreadyExistsException(command.email());
        }

        Customer customer = new Customer(
                null,
                command.name(),
                command.email(),
                command.document()
        );

        Customer saved = customerPort.save(customer);

        return CustomerResponse.fromDomain(saved);

    }
}
