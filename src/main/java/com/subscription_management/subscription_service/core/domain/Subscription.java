package com.subscription_management.subscription_service.core.domain;

import com.subscription_management.subscription_service.core.domain.exception.InvalidSubscriptionOperationException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Subscription {

    private final Long id;
    private final Customer customer;
    private final Plan plan;
    private SubscriptionStatus status;
    private final LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime nextBillingDate;
    private BigDecimal lastPaymentAmount;
    private String paymentMethod;

    public Subscription(SubscriptionStatus status, Long id, Customer customer, Plan plan,
                        LocalDateTime startDate, LocalDateTime endDate, LocalDateTime nextBillingDate,
                        BigDecimal lastPaymentAmount, String paymentMethod) {
        this.status = status;
        this.id = id;
        this.customer = customer;
        this.plan = plan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nextBillingDate = nextBillingDate;
        this.lastPaymentAmount = lastPaymentAmount;
        this.paymentMethod = paymentMethod;
    }
        public void cancel(){
            if(this.status == SubscriptionStatus.CANCELLED){
                throw new InvalidSubscriptionOperationException("Subscription already cancelled");
            }
            if(this.status == SubscriptionStatus.EXPIRED){
                throw new InvalidSubscriptionOperationException("Cannot cancel expired subscription");
            }
            this.status = SubscriptionStatus.CANCELLED;
        }

        public void renew(BigDecimal paymentAmount){
            if(this.status != SubscriptionStatus.ACTIVE){
                throw new InvalidSubscriptionOperationException("Only active subscriptions can be renewed");
            }
            if(paymentAmount == null || paymentAmount.compareTo(this.plan.getPrice()) < 0){
                throw new InvalidSubscriptionOperationException("Insufficient payment amount");
            }

            this.lastPaymentAmount = paymentAmount;
            this.endDate = this.endDate.plusMonths(plan.getDurationMonths());
            this.nextBillingDate = calculateNextBillingDate();

        }

        public boolean isExpired(){
            return LocalDateTime.now().isAfter(endDate);
        }

        public boolean isActive(){
            return this.status == SubscriptionStatus.ACTIVE && !isExpired();
        }

        private LocalDateTime calculateNextBillingDate() {
            return LocalDateTime.now().plusMonths(plan.getDurationMonths());
        }

        private LocalDateTime calculateEndDate(Plan plan){
            return LocalDateTime.now().plusMonths(plan.getDurationMonths());
        }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Plan getPlan() {
        return plan;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }
}
