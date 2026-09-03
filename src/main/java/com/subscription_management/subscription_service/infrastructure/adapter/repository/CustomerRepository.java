package com.subscription_management.subscription_service.infrastructure.adapter.repository;

import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
