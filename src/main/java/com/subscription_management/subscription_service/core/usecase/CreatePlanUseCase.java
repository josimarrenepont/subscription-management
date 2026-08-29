package com.subscription_management.subscription_service.core.usecase;

import com.subscription_management.subscription_service.core.domain.Plan;
import com.subscription_management.subscription_service.core.port.PlanStoragePort;
import com.subscription_management.subscription_service.core.usecase.model.CreatePlanCommand;
import com.subscription_management.subscription_service.core.usecase.model.PlanResponse;

public class CreatePlanUseCase {

    private final PlanStoragePort planPort;

    public CreatePlanUseCase(PlanStoragePort planPort) {
        this.planPort = planPort;
    }

    public PlanResponse execute(CreatePlanCommand command){
        if(planPort.existsByName(command.name())){
            throw new IllegalArgumentException("Plan name already exists");
        }
      Plan plan = new Plan(
              null,
              command.name(),
              command.description(),
              command.type(),
              command.price(),
              command.durationMonths()
      );

      Plan saved = planPort.save(plan);

      return PlanResponse.fromDomain(saved);
    }
}
