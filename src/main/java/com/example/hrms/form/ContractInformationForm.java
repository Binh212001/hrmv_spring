package com.example.hrms.form;

import lombok.Data;

@Data
public class ContractInformationForm {
    private Long employeeId;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
