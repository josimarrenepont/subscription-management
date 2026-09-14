package com.subscription_management.subscription_service.core.domain;
import com.subscription_management.subscription_service.core.domain.exception.InvalidSubscriptionOperationException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionTest {

    private Subscription createSubscription(){
      return new Subscription(1L, createCustomer(), createPlan(), SubscriptionStatus.ACTIVE,
              LocalDateTime.now(),
              LocalDateTime.of(2026, 9, 13, 20, 0, 0),
              LocalDateTime.of(2026, 9, 14, 21, 0, 0),
              new BigDecimal("29.95"), "CREDIT_CARD");

    }

    private Subscription createSubscriptionWithStatus(SubscriptionStatus status){
        return new Subscription(2L, createCustomer(), createPlan(), status, LocalDateTime.now()
        , LocalDateTime.of(2026, 9, 13, 20, 0, 0),
                LocalDateTime.of(2026, 9, 14, 21, 0, 0),
                new BigDecimal("29.95"), "CREDIT_CARD");
    }

    private Plan createPlan(){
        return new Plan(1L, "Basic", "Plan Basic",
                PlanType.MONTHLY, new BigDecimal("29.95"), 1);
    }

    private Customer createCustomer(){
        return new Customer(1L, "Pedro", "pedro@email.com", "123456789");
    }

    @Test
    public void cancelSubscription(){
        Subscription subscription = createSubscription();
        subscription.cancel();
        assertEquals(SubscriptionStatus.CANCELLED, subscription.getStatus());
    }

    @Test
    public void renewSubscription(){
        Subscription subscription = createSubscription();
        subscription.renew(new BigDecimal("29.95"));
        assertEquals(SubscriptionStatus.ACTIVE, subscription.getStatus());
    }

    @Test
    public void renewSubscriptionCanceled(){
        Subscription subscription1 = createSubscriptionWithStatus(SubscriptionStatus.CANCELLED);

        assertThrows(InvalidSubscriptionOperationException.class, () -> {
            subscription1.renew(new BigDecimal("29.90"));
          });
        }

    @Test
    public void renewSubscriptionExpired(){
        Subscription subscription2 = createSubscriptionWithStatus(SubscriptionStatus.EXPIRED);

        assertThrows(InvalidSubscriptionOperationException.class, ()-> {
            subscription2.renew(new BigDecimal("29.90"));
        });
    }

    @Test
    public void cancelAlreadyCancelledSubscription(){
        Subscription subscription = createSubscriptionWithStatus(SubscriptionStatus.CANCELLED);
        assertThrows(InvalidSubscriptionOperationException.class, subscription::cancel);
    }

    @Test
    public void cancelExpiredSubscription(){
        Subscription subscription = createSubscriptionWithStatus(SubscriptionStatus.EXPIRED);
        assertThrows(InvalidSubscriptionOperationException.class, subscription::cancel);
    }

    @Test
    public void renewSubscriptionInsufficientPayment(){
        Subscription subscription = createSubscription();
        assertThrows(InvalidSubscriptionOperationException.class, () -> {
                subscription.renew(new BigDecimal("10.00"));
        });
    }

    @Test
    public void renewSubscriptionNullPayment(){
        Subscription subscription = createSubscription();

        assertThrows(InvalidSubscriptionOperationException.class, () ->{
           subscription.renew(null);
        });
    }

    @Test
    public void testActiveAndExpiredLogic(){
        Subscription activeSub = new Subscription(
                createCustomer(), createPlan(), new BigDecimal("29.90"),
                "PIX");

        assertTrue(activeSub.isActive());
        assertFalse(activeSub.isExpired());

        Subscription expiredSub = new Subscription(
                3L, createCustomer(), createPlan(), SubscriptionStatus.ACTIVE,
                LocalDateTime.now().minusDays(40), LocalDateTime.now().minusDays(10),
                LocalDateTime.now().minusDays(10), new BigDecimal("29.95"), "CREDIT_CARD"
        );

        assertTrue(expiredSub.isExpired());
        assertFalse(expiredSub.isActive());
    }
}
