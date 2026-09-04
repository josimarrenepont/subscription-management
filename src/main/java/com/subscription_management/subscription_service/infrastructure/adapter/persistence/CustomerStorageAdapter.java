package com.subscription_management.subscription_service.infrastructure.adapter.persistence;

import com.subscription_management.subscription_service.core.domain.Customer;
import com.subscription_management.subscription_service.core.port.CustomerStoragePort;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.CustomerEntity;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.mapper.CustomerPersistenceMapper;
import com.subscription_management.subscription_service.infrastructure.adapter.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerStorageAdapter implements CustomerStoragePort {

    private final CustomerRepository customerRepository;

    public CustomerStorageAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        var entityToSave = CustomerPersistenceMapper.toEntity(customer);
        var savedEntity = customerRepository.save(entityToSave);

        return CustomerPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerPersistenceMapper::toDomain);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll()
                .stream().map(CustomerPersistenceMapper::toDomain).toList();
    }
}
