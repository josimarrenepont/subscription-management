package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.core.domain.exception.PlanNotFoundException;
import com.subscription_management.subscription_service.core.port.PlanStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.PlanResponse;

public class FindPlanUseCase {

    private final PlanStoragePort planStoragePort;

    public FindPlanUseCase(PlanStoragePort planStoragePort) {
        this.planStoragePort = planStoragePort;
    }

    public PlanResponse execute(Long planId){
        Plan plan = planStoragePort.findById(planId)
                .orElseThrow(() -> new PlanNotFoundException(planId));

        return PlanResponse.fromDomain(plan);
    }
}
