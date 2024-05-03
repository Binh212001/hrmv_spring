package com.example.hrms.form;

import lombok.Data;

import java.util.Date;
@Data
public class ContractForm {
    private Long employeeId;
    private Date startDate;
    private Date endDate;
    private String contractType;
    private Double salary;
}
