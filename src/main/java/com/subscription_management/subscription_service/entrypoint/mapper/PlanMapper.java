package com.subscription_management.subscription_service.entrypoint.mapper;

import com.subscription_management.subscription_service.core.usecase.model.CreatePlanCommand;
import com.subscription_management.subscription_service.core.usecase.model.PlanResponse;
import com.subscription_management.subscription_service.entrypoint.dto.PlanRequestDTO;
import com.subscription_management.subscription_service.entrypoint.dto.PlanResponseDTO;

public class PlanMapper {

    public static CreatePlanCommand toCommand(PlanRequestDTO request){
        return new CreatePlanCommand(
                request.name(),
                request.description(),
                request.type(),
                request.price(),
                request.durationMonths()
        );
    }
    public static PlanResponseDTO toDTO(PlanResponse response){
        return new PlanResponseDTO(
                response.id(),
                response.name(),
                response.description(),
                response.type(),
                response.price(),
                response.durationMonths()
        );
    }
}
