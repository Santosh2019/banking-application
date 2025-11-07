package com.banking.service;

import com.banking.dto.CustomerDto;
import com.banking.entity.Customer;
import com.banking.mapper.CustomerMapper;
import com.banking.repo.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements BankService {

    private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerDto addCustomer(Customer customer) {
        validateCustomerFields(customer);
        if (customerRepo.findByEmailId(customer.getEmailId()).isPresent()) {
            throw new RuntimeException("Customer already exists with this email");
        }
        if (customerRepo.findByAadharNumber(customer.getAadharNumber()).isPresent()) {
            throw new RuntimeException("Aadhaar Number Already Registered with "
                    + customer.getFirstName() + " " + customer.getLastName());
        }
        if (customerRepo.findByPhoneNumber(customer.getPhoneNumber()).isPresent()) {
            throw new RuntimeException("Mobile number already exists with :" + customer.getAadharNumber());
        }
        Customer customerSave = customerRepo.save(customer);
        logger.info("saving customer details {} ", customerSave);
        return CustomerMapper.toCustomerDto(customerSave);
    }

    @Override
    public CustomerDto getCustomer(String aadharNumber) {
        Customer customerDto = customerRepo.findByAadharNumber(aadharNumber)
                .orElseThrow(() -> new RuntimeException("Customer Not Found "));
        logger.info("Getting customer details {} ", customerDto);
        return CustomerMapper.toCustomerDto(customerDto);
    }

    @Override
    public CustomerDto deleteCustomer(String aadharNumber) {
        Customer customerDto = customerRepo.findByAadharNumber(aadharNumber)
                .orElseThrow(() -> new RuntimeException("Customer Not Found "));
        customerRepo.delete(customerDto);
        logger.info("Deleting customer details {} ", customerDto);
        return CustomerMapper.toCustomerDto(customerDto);
    }

    @Override
    public CustomerDto updateCustomer(String aadharNumber, Customer customerDetails) {
        Customer existingCustomer = customerRepo.findByAadharNumber(aadharNumber)
                .orElseThrow(() -> new RuntimeException("Customer Not Found with Aadhaar: " + aadharNumber));
        existingCustomer.setFirstName(customerDetails.getFirstName());
        existingCustomer.setMiddleName(customerDetails.getMiddleName());
        existingCustomer.setLastName(customerDetails.getLastName());
        existingCustomer.setEmailId(customerDetails.getEmailId());
        existingCustomer.setPassword(customerDetails.getPassword());
        existingCustomer.setPandCardNumber(customerDetails.getPandCardNumber());
        existingCustomer.setCustomerNationality(customerDetails.getCustomerNationality());
        existingCustomer.setCustomerState(customerDetails.getCustomerState());
        existingCustomer.setCustomerDistrict(customerDetails.getCustomerDistrict());
        existingCustomer.setTaluka(customerDetails.getTaluka());
        existingCustomer.setUserName(customerDetails.getUserName());
        existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        Customer updatedCustomer = customerRepo.save(existingCustomer);
        logger.info("Updating customer details {} ", updatedCustomer);
        return CustomerMapper.toCustomerDto(updatedCustomer);
    }

    private void validateCustomerFields(Customer customer) {
        if (customer.getFirstName() == null || customer.getFirstName().trim().isEmpty()) {
            throw new RuntimeException("First name is required");
        }
        if (customer.getLastName() == null || customer.getLastName().trim().isEmpty()) {
            throw new RuntimeException("Last name is required");
        }
        if (customer.getAadharNumber() == null || customer.getAadharNumber().trim().isEmpty()) {
            throw new RuntimeException("Aadhaar number is required");
        }
        if (customer.getPhoneNumber() == null || customer.getPhoneNumber().trim().isEmpty()) {
            throw new RuntimeException("Phone number is required");
        }
        if (customer.getEmailId() == null || customer.getEmailId().trim().isEmpty()) {
            throw new RuntimeException("Email ID is required");
        }
        if (customer.getPassword() == null || customer.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password is required");
        }
        if (customer.getUserName() == null || customer.getUserName().trim().isEmpty()) {
            throw new RuntimeException("Username is required");
        }
    }

}
