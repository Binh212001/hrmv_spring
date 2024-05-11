package com.example.hrms.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
public class AttendanceForm {
    Long id;
    Long employeeId;
    LocalDate date;
    LocalTime clockInTime;
    LocalTime clockOutTime;
}
