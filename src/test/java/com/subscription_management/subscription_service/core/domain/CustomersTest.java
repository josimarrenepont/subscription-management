package com.subscription_management.subscription_service.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomersTest {

    @Test
    public void shouldCreateCustomerSuccessfully(){

        Customer customer = new Customer(1L, "Pedro", "pedro@email.com",
                "123456789");

        assertEquals(1L, customer.getId());
        assertEquals("Pedro", customer.getName());
        assertEquals("pedro@email.com", customer.getEmail());
        assertEquals("123456789", customer.getDocument());
    }

    @Test
    public void testCustomerEqualsAndHashCode(){
        Customer customer1 = new Customer(1L, "Pedro", "pedro@email.com", "123456789");
        Customer customer2 = new Customer(1L, "Pedro", "pedro@email.com", "123456789");
        Customer customer3 = new Customer(2L, "Ana", "ana@email.com", "987654321");

        assertEquals(customer1, customer2);
        assertEquals(customer1.hashCode(), customer2.hashCode());
        assertNotEquals(customer1, customer3);
        assertNotEquals(customer1, null);
    }
}
