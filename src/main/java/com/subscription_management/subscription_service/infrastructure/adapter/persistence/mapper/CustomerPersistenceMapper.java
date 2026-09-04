package com.subscription_management.subscription_service.infrastructure.adapter.persistence.mapper;

import com.subscription_management.subscription_service.core.domain.Customer;
import com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity.CustomerEntity;

public class CustomerPersistenceMapper {
    public static CustomerEntity toEntity(Customer domain){
        if(domain == null) return null;
        return new CustomerEntity(
            domain.getId(),
            domain.getName(),
            domain.getEmail(),
            domain.getDocument()
        );
    }

    public static Customer toDomain(CustomerEntity entity){
        if(entity == null) return null;
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getDocument()
        );
    }
}
