package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.core.domain.exception.PlanNotFoundException;
import com.subscription_management.subscription_service.core.port.PlanStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.PlanResponse;

public class FindPlanUseCase {

    private final PlanStoragePort planPort;

    public FindPlanUseCase(PlanStoragePort planPort) {
        this.planPort = planPort;
    }

    public PlanResponse execute(Long planId){
        Plan plan = planPort.findById(planId)
                .orElseThrow(() -> new PlanNotFoundException(planId));

        return PlanResponse.fromDomain(plan);
    }
}
