package com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity;

import com.subscription_management.subscription_service.core.domain.PlanType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_plans")
@NoArgsConstructor
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "plan_type", nullable = false)
    private PlanType type;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "duration_months")
    private int durationMonths;

    public PlanEntity(Long id, String name, String description, PlanType type,
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
