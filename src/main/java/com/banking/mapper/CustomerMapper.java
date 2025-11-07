package com.banking.mapper;

import com.banking.dto.CustomerDto;
import com.banking.entity.Customer;

public class CustomerMapper {
    public static Customer toCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setMiddleName(customerDto.getMiddleName());
        customer.setLastName(customerDto.getLastName());
        customer.setAadharNumber(customerDto.getAadharNumber());
        customer.setCustomerNationality(customerDto.getCustomerNationality());
        customer.setCustomerState(customerDto.getCustomerState());
        customer.setCustomerDistrict(customerDto.getCustomerDistrict());
        customer.setTaluka(customerDto.getTaluka());
        customer.setPandCardNumber(customerDto.getPandCardNumber());
        customer.setUserName(customerDto.getUserName());
        customer.setPassword(customerDto.getPassword());
        customer.setEmailId(customerDto.getEmailId());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setPinCode(customer.getPinCode());
        return customer;
    }


    public static CustomerDto toCustomerDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setFirstName(customer.getFirstName());
        dto.setMiddleName(customer.getMiddleName());
        dto.setLastName(customer.getLastName());
        dto.setAadharNumber(customer.getAadharNumber());
        dto.setCustomerNationality(customer.getCustomerNationality());
        dto.setCustomerState(customer.getCustomerState());
        dto.setCustomerDistrict(customer.getCustomerDistrict());
        dto.setTaluka(customer.getTaluka());
        dto.setPandCardNumber(customer.getPandCardNumber());
        dto.setUserName(customer.getUserName());
        dto.setPassword(customer.getPassword());
        dto.setEmailId(customer.getEmailId());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setPinCode(customer.getPinCode());
        return dto;
    }
}

