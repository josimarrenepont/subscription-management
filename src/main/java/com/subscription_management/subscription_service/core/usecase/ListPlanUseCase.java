package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.core.port.PlanStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.PlanResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ListPlanUseCase {

    private final PlanStoragePort planStoragePort;

    public ListPlanUseCase(PlanStoragePort planStoragePort) {
        this.planStoragePort = planStoragePort;
    }

    public List<PlanResponse> execute(){

        return planStoragePort.findAll().stream().map(PlanResponse::fromDomain)
                .collect(Collectors.toList());
    }
}
