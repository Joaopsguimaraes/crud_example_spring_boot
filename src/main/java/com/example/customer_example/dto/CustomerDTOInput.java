package com.example.customer_example.dto;

public record CustomerDTOInput(
    String firstName, 
    String lastName,
    Boolean isActive,
    Integer age,
    String address,
    String city
) {}