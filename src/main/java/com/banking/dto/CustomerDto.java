package com.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String aadharNumber;
    private String pandCardNumber;
    private String phoneNumber;
    private String customerNationality;
    private String customerState;
    private String customerDistrict;
    private String taluka;
    private int pinCode;
    private String emailId;
    private String userName;
    private String password;

    // private Address address;
}
