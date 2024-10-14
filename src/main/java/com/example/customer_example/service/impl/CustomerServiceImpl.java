package com.example.customer_example.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_example.dto.CustomerDTOInput;
import com.example.customer_example.dto.CustomerDTOOutput;
import com.example.customer_example.mapper.CustomerMapper;
import com.example.customer_example.repository.CustomerRepository;
import com.example.customer_example.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerMapper customerMapper;

  @Override
  public void createCustomer(CustomerDTOInput customerDTOInput) {
    this.customerRepository.save(this.customerMapper.toEntity(customerDTOInput));
  }

  @Override
  public void updateCustomerById(UUID id, CustomerDTOInput customerDTOInput) {
    var customer = this.customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

    this.customerMapper.updatedEntityFromInputDTO(customerDTOInput, customer);

    this.customerRepository.save(customer);
  }

  @Override
  public CustomerDTOOutput getCustomerById(UUID id) {
    var customer = this.customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

    return this.customerMapper.toOutputDTO(customer);
  }

  @Override
  public List<CustomerDTOOutput> getCustomerList() {
    List<CustomerDTOOutput> customerList = this.customerRepository.findAll().stream().map(customerMapper::toOutputDTO)
            .collect(Collectors.toList());

    return customerList;
  }

  @Override
  public void deleteCustomerById(UUID id) {
    this.customerRepository.deleteById(id);
  }

}
