package com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity;

import com.subscription_management.subscription_service.core.domain.PlanType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_plans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
