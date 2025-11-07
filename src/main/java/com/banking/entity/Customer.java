package com.banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private String firstName;
    private String middleName;
    private String lastName;
    @Id
    private String aadharNumber;
    private String pandCardNumber;
    private String phoneNumber;
    private String emailId;
    private String userName;
    private String password;
    private String customerNationality;
    private String customerState;
    private String customerDistrict;
    private String taluka;
    private int pinCode;

    //private Address address;
}
