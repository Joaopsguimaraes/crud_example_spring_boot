package com.example.customer_example.service;

import com.example.customer_example.dto.CustomerDTOInput;
import com.example.customer_example.dto.CustomerDTOOutput;

import java.util.UUID;
import java.util.List;

public interface CustomerService {
  public void createCustomer(CustomerDTOInput customerDTOInput);

  public void updateCustomerById(UUID id, CustomerDTOInput customerDTOInput);

  public CustomerDTOOutput getCustomerById(UUID id);

  public List<CustomerDTOOutput> getCustomerList();

  public void deleteCustomerById(UUID id);
}
