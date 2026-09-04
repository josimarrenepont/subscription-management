package com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity;
import com.subscription_management.subscription_service.core.domain.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_subscriptions")
@NoArgsConstructor
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private PlanEntity plan;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus status;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "next_billing_date")
    private LocalDateTime nextBillingDate;

    @Column(name = "last_payment_amount", precision = 10, scale = 2)
    private BigDecimal lastPaymentAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    public SubscriptionEntity(Long id, PlanEntity plan, CustomerEntity customer,
                              SubscriptionStatus status, LocalDateTime startDate,
                              LocalDateTime endDate, LocalDateTime nextBillingDate,
                              BigDecimal lastPaymentAmount, String paymentMethod) {
        this.id = id;
        this.plan = plan;
        this.customer = customer;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nextBillingDate = nextBillingDate;
        this.lastPaymentAmount = lastPaymentAmount;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public PlanEntity getPlan() {
        return plan;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public LocalDateTime getNextBillingDate() {
        return nextBillingDate;
    }

    public BigDecimal getLastPaymentAmount() {
        return lastPaymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
