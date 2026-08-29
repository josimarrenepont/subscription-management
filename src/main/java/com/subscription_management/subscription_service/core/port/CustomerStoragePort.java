package com.subscription_management.subscription_service.core.port;
import com.subscription_management.subscription_service.core.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerStoragePort {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    void delete(Long id);
    boolean existsByEmail(String email);
    List<Customer> findAll();
}
