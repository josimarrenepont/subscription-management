package com.subscription_management.subscription_service.entrypoint.mapper;

import com.subscription_management.subscription_service.core.usecase.model.CreateCustomerCommand;
import com.subscription_management.subscription_service.core.usecase.model.CustomerResponse;
import com.subscription_management.subscription_service.entrypoint.dto.CustomerRequestDTO;
import com.subscription_management.subscription_service.entrypoint.dto.CustomerResponseDTO;

public class CustomerMapper {

    public static CreateCustomerCommand toCommand(CustomerRequestDTO request){
        return new CreateCustomerCommand(
                request.name(),
                request.email(),
                request.document()

        );
    }
    public static CustomerResponseDTO toDTO(CustomerResponse response){
        return new CustomerResponseDTO(
                response.id(),
                response.name(),
                response.email(),
                response.document()
        );
    }
}
