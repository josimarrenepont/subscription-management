package com.subscription_management.subscription_service.entrypoint.controller;

import com.subscription_management.subscription_service.core.usecase.CreateCustomerUseCase;
import com.subscription_management.subscription_service.core.usecase.FindCustomerUseCase;
import com.subscription_management.subscription_service.core.usecase.ListCustomersUseCase;
import com.subscription_management.subscription_service.core.usecase.model.CreateCustomerCommand;
import com.subscription_management.subscription_service.core.usecase.model.CustomerResponse;
import com.subscription_management.subscription_service.entrypoint.dto.CustomerRequestDTO;
import com.subscription_management.subscription_service.entrypoint.dto.CustomerResponseDTO;
import com.subscription_management.subscription_service.entrypoint.mapper.CustomerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final FindCustomerUseCase findCustomerUseCase;
    private final ListCustomersUseCase listCustomersUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase,
                              FindCustomerUseCase findCustomerUseCase,
                              ListCustomersUseCase listCustomersUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.findCustomerUseCase = findCustomerUseCase;
        this.listCustomersUseCase = listCustomersUseCase;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO request){
        CreateCustomerCommand command = CustomerMapper.toCommand(request);
        CustomerResponse response = createCustomerUseCase.execute(command);
        CustomerResponseDTO dto = CustomerMapper.toDTO(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

}
