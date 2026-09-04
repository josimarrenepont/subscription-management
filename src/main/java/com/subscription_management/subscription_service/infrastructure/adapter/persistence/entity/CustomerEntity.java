package com.subscription_management.subscription_service.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_customers")
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String email;

    private String document;

    public CustomerEntity(Long id, String name, String email, String document) {
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
