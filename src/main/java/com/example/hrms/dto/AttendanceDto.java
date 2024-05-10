package com.example.hrms.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link com.example.hrms.entities.Attendance}
 */
@Value
public class AttendanceDto implements Serializable {
    Integer id;
    EmployeeDto employee;
    LocalDate date;
    LocalTime clockInTime;
    LocalTime clockOutTime;
}