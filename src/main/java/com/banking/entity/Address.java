package com.banking.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private int pinCode;
    private String customerNationality;
    private String customerState;
    private String customerDistrict;
    private String taluka;
}
