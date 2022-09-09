package com.program.reward.controller;


import com.program.reward.model.Customer;
import com.program.reward.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/page={pageNumber}")
    public Page<Customer> getAllCustomers(@PathVariable @Min(1) int pageNumber) {
        return customerRepository.findAll(Pageable.ofSize(1000).withPage(pageNumber - 1));
    }
}
