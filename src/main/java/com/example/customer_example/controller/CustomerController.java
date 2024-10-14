package com.example.customer_example.controller;

import com.example.customer_example.dto.CustomerDTOInput;
import com.example.customer_example.dto.CustomerDTOOutput;
import com.example.customer_example.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTOOutput>> getAllCustomers() {
        return ResponseEntity.ok(this.customerService.getCustomerList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTOOutput> getCustomerById(@PathVariable UUID id) {
        return ResponseEntity.ok(this.customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDTOInput customerDTOInput) {
        this.customerService.createCustomer(customerDTOInput);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable UUID id, @RequestBody CustomerDTOInput customerDTOInput) {
        this.customerService.updateCustomerById(id, customerDTOInput);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id) {
        this.customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }


}
