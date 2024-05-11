package com.example.hrms.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link com.example.hrms.entities.Attendance}
 */
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AttendanceDto  {
    Long id;
    Long employeeId;
    LocalDate date;
    LocalTime clockInTime;
    LocalTime clockOutTime;
    String employeeName;
}