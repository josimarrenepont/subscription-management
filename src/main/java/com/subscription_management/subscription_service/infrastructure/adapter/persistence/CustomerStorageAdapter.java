package com.subscription_management.subscription_service.infrastructure.adapter.persistence;

import com.subscription_management.subscription_service.core.domain.Customer;
import com.subscription_management.subscription_service.core.port.CustomerStoragePort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerStorageAdapter implements CustomerStoragePort {

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
