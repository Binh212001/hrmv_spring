package com.example.hrms.dto;

import lombok.Value;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link com.example.hrms.entities.Attendance}
 */
@Value
public class AttendanceDto  {
    Long id;
    String employeeName;
    LocalDate date;
    LocalTime clockInTime;
    LocalTime clockOutTime;
}