package com.subscription_management.subscription_service.entrypoint.controller;

import com.subscription_management.subscription_service.core.usecase.CreatePlanUseCase;
import com.subscription_management.subscription_service.core.usecase.FindPlanUseCase;
import com.subscription_management.subscription_service.core.usecase.model.CreatePlanCommand;
import com.subscription_management.subscription_service.core.usecase.model.PlanResponse;
import com.subscription_management.subscription_service.entrypoint.dto.PlanRequestDTO;
import com.subscription_management.subscription_service.entrypoint.dto.PlanResponseDTO;
import com.subscription_management.subscription_service.entrypoint.mapper.PlanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/plans")
public class PlanController {

    private final CreatePlanUseCase createPlanUseCase;
    private final FindPlanUseCase findPlanUseCase;

    public PlanController(CreatePlanUseCase createPlanUseCase, FindPlanUseCase findPlanUseCase) {
        this.createPlanUseCase = createPlanUseCase;
        this.findPlanUseCase = findPlanUseCase;
    }

    @PostMapping
    public ResponseEntity<PlanResponseDTO> createPlan(@RequestBody PlanRequestDTO request){
        CreatePlanCommand command = PlanMapper.toCommand(request);
        PlanResponse response = createPlanUseCase.execute(command);
        PlanResponseDTO dto = PlanMapper.toDTO(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
