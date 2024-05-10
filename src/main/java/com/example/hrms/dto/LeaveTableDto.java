package com.example.hrms.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.LeaveTable}
 */
@Value
public class LeaveTableDto implements Serializable {
    Integer id;
    EmployeeDto employee;
    String leaveType;
    LocalDate startDate;
    LocalDate endDate;
    String reason;
}