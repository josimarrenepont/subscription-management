package com.subscription_management.subscription_service.core.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlanTest {

    @Test
    public void shouldCreatePlanSuccessfully(){

        Plan plan = new Plan(1L, "Monthly", "Plan Monthly", PlanType.MONTHLY,
                new BigDecimal("29.90"), 1);

        assertEquals(1L, plan.getId());
        assertEquals("Monthly", plan.getName());
        assertEquals("Plan Monthly", plan.getDescription());
        assertEquals(plan.getType(), PlanType.MONTHLY);
        assertEquals(new BigDecimal("29.90"), plan.getPrice());
        assertEquals(1, plan.getDurationMonths());
    }

    @Test
    public void testPlanEqualsAndHashCode(){

        Plan plan1 = new Plan(1L, "Basic", "Plan Monthly", PlanType.MONTHLY,
                new BigDecimal("29.90"), 1);
        Plan plan2 = new Plan(1L, "Quarterly", "Plan Quarterly", PlanType.QUARTERLY,
                new BigDecimal("59.90"), 3);
        Plan plan3 = new Plan(2L, "Annual", "Plan Annual", PlanType.ANNUAL,
                new BigDecimal("99.90"), 12);

        assertEquals(plan1, plan2);
        assertEquals(plan1.hashCode(), plan2.hashCode());
        assertNotEquals(plan1, plan3);
        assertNotEquals(plan1, null);
    }
}
