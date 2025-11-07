package com.banking.service;

import com.banking.dto.CustomerDto;
import com.banking.entity.Customer;

public interface BankService {
    CustomerDto addCustomer(Customer customer);

    CustomerDto getCustomer(String aadharNumber);

    CustomerDto deleteCustomer(String aadharNumber);

    CustomerDto updateCustomer(String aadharNumber, Customer customerDetails);

}
