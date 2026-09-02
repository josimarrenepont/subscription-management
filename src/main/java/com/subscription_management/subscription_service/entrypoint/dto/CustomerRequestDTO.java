package com.subscription_management.subscription_service.entrypoint.dto;

public record CustomerRequestDTO(
        String name,
        String email,
        String document
) {
}
