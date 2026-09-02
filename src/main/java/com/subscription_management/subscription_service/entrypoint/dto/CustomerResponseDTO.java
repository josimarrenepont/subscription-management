package com.subscription_management.subscription_service.entrypoint.dto;

public record CustomerResponseDTO(

        Long id,
        String name,
        String email,
        String document
) {
}
