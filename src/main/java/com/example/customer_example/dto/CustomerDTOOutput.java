package com.example.customer_example.dto;

import java.time.Instant;
import java.util.UUID;

public record CustomerDTOOutput(
    UUID id,
    String firstName,
    String lastName,
    Boolean isActive,
    Integer age,
    String address,
    String city,
    Instant createdAt,
    Instant updatedAt) {
}
