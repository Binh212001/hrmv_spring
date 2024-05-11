package com.example.hrms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class AttendanceListDto {
    private Long employeeId;
    private String employeeName;
    private BigDecimal year;
    private BigDecimal month;
}
