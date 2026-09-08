package com.subscription_management.subscription_service.entrypoint.controller;

import com.subscription_management.subscription_service.core.usecase.CreatePlanUseCase;
import com.subscription_management.subscription_service.core.usecase.FindPlanUseCase;
import com.subscription_management.subscription_service.core.usecase.ListPlanUseCase;
import com.subscription_management.subscription_service.core.usecase.model.CreatePlanCommand;
import com.subscription_management.subscription_service.core.usecase.model.PlanResponse;
import com.subscription_management.subscription_service.entrypoint.dto.PlanRequestDTO;
import com.subscription_management.subscription_service.entrypoint.dto.PlanResponseDTO;
import com.subscription_management.subscription_service.entrypoint.mapper.PlanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/plans")
public class PlanController {

    private final CreatePlanUseCase createPlanUseCase;
    private final FindPlanUseCase findPlanUseCase;
    private final ListPlanUseCase listPlanUseCase;

    public PlanController(CreatePlanUseCase createPlanUseCase, FindPlanUseCase findPlanUseCase, ListPlanUseCase listPlanUseCase) {
        this.createPlanUseCase = createPlanUseCase;
        this.findPlanUseCase = findPlanUseCase;
        this.listPlanUseCase = listPlanUseCase;
    }

    @PostMapping
    public ResponseEntity<PlanResponseDTO> createPlan(@RequestBody PlanRequestDTO request){
        CreatePlanCommand command = PlanMapper.toCommand(request);
        PlanResponse response = createPlanUseCase.execute(command);
        PlanResponseDTO dto = PlanMapper.toDTO(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanResponseDTO> findById(@PathVariable Long id){
        PlanResponse response = findPlanUseCase.execute(id);
        PlanResponseDTO dto = PlanMapper.toDTO(response);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PlanResponseDTO>> findAll(){

       List<PlanResponse> responses = listPlanUseCase.execute();
       List<PlanResponseDTO> dtos = responses.stream().map(PlanMapper::toDTO)
               .collect(Collectors.toList());

       return ResponseEntity.ok(dtos);
    }
}
