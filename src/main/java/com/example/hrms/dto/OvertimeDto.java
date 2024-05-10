package com.example.hrms.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.Overtime}
 */
@Value
public class OvertimeDto implements Serializable {
    Integer id;
    EmployeeDto employee;
    LocalDate date;
    BigDecimal hoursWorked;
    String reason;
}