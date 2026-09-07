package com.subscription_management.subscription_service.entrypoint.controller;

import com.subscription_management.subscription_service.core.usecase.*;
import com.subscription_management.subscription_service.core.usecase.model.CancelSubscriptionCommand;
import com.subscription_management.subscription_service.core.usecase.model.CreateSubscriptionCommand;
import com.subscription_management.subscription_service.core.usecase.model.RenewSubscriptionCommand;
import com.subscription_management.subscription_service.core.usecase.model.SubscriptionResponse;
import com.subscription_management.subscription_service.entrypoint.dto.SubscriptionRequestDTO;
import com.subscription_management.subscription_service.entrypoint.dto.SubscriptionResponseDTO;
import com.subscription_management.subscription_service.entrypoint.mapper.SubscriptionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/subscriptions")
public class SubscriptionController {

    private final CreateSubscriptionUseCase createSubscriptionUseCase;
    private final CancelSubscriptionUseCase cancelSubscriptionUseCase;
    private final FindSubscriptionUseCase findSubscriptionUseCase;
    private final RenewSubscriptionUseCase renewSubscriptionUseCase;

    public SubscriptionController(CreateSubscriptionUseCase createSubscriptionUseCase,
                                  CancelSubscriptionUseCase cancelSubscriptionUseCase,
                                  FindSubscriptionUseCase findSubscriptionUseCase,
                                  RenewSubscriptionUseCase renewSubscriptionUseCase) {
        this.createSubscriptionUseCase = createSubscriptionUseCase;
        this.cancelSubscriptionUseCase = cancelSubscriptionUseCase;
        this.findSubscriptionUseCase = findSubscriptionUseCase;
        this.renewSubscriptionUseCase = renewSubscriptionUseCase;
    }

    @PostMapping
    public ResponseEntity<SubscriptionResponseDTO> createSubscription(@RequestBody
                                                                      SubscriptionRequestDTO request){

        CreateSubscriptionCommand command = SubscriptionMapper.toCommand(request);
        SubscriptionResponse response = createSubscriptionUseCase.execute(command);
        SubscriptionResponseDTO dto = SubscriptionMapper.toDTO(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponseDTO> findById(@PathVariable Long id){

        SubscriptionResponse response = findSubscriptionUseCase.execute(id);
        SubscriptionResponseDTO dto = SubscriptionMapper.toDTO(response);

        return ResponseEntity.ok(dto);

    }

    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<Void> cancelSubscription(@PathVariable Long subscriptionId){

        cancelSubscriptionUseCase.execute(new CancelSubscriptionCommand(subscriptionId));

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/renew")
    public ResponseEntity<SubscriptionResponseDTO> renewSubscription(@PathVariable Long id){

        SubscriptionResponse response = renewSubscriptionUseCase.execute(new RenewSubscriptionCommand(id));
        SubscriptionResponseDTO dto = SubscriptionMapper.toDTO(response);

        return ResponseEntity.ok(dto);
    }
}
