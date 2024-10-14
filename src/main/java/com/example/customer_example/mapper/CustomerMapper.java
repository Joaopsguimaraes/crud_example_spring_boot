package com.example.customer_example.mapper;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.example.customer_example.dto.CustomerDTOInput;
import com.example.customer_example.dto.CustomerDTOOutput;
import com.example.customer_example.model.Customer;

@Component
public class CustomerMapper {

  public CustomerDTOOutput toOutputDTO(Customer customer) {
    return new CustomerDTOOutput(
        customer.getId(),
        customer.getFirstName(),
        customer.getLastName(),
        customer.getIsActive(),
        customer.getAge(),
        customer.getAddress(),
        customer.getCity(),
        customer.getCreatedAt(),
        customer.getUpdatedAt());
  }

  public Customer toEntity(CustomerDTOInput customerDTOInput) {
    return new Customer(
        customerDTOInput.firstName(),
        customerDTOInput.lastName(),
        customerDTOInput.age(),
        customerDTOInput.address(),
        customerDTOInput.city());
  }

  public void updatedEntityFromInputDTO(CustomerDTOInput customerDTOInput, Customer customer) {
    customer.setFirstName(customerDTOInput.firstName());
    customer.setLastName(customerDTOInput.lastName());
    customer.setIsActive(customerDTOInput.isActive());
    customer.setAge(customerDTOInput.age());
    customer.setCity(customerDTOInput.city());
    customer.setUpdatedAt(Instant.now());
  }
}
