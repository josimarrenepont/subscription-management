package com.subscription_management.subscription_service.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Customer {

    private final Long id;
    private final String name;
    private final String email;
    private final String document;

    public Customer(Long id, String name, String email, String document) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDocument() {
        return document;
    }
}
