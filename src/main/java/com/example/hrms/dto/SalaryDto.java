package com.example.hrms.dto;

import lombok.Data;

import java.util.Date;
@Data
public class SalaryDto {
    private Long salaryId;
    private Long employeeId;
    private  String fullName;
    private Double salaryAmount;
    private Date startDate;
    private Date endDate;
    private  Float sum;
}
