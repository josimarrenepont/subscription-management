package com.subscription_management.subscription_service.core.domain;


import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
public class Plan {

    private final Long id;
    private final String name;
    private final String description;
    private final PlanType type;
    private final BigDecimal price;
    private final int durationMonths;

    public Plan(Long id, String name, String description, PlanType type,
                BigDecimal price, int durationMonths) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.durationMonths = durationMonths;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public PlanType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getDurationMonths() {
        return durationMonths;
    }
}
