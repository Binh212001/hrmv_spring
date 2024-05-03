package com.example.hrms.dto;

import com.example.hrms.entities.Status;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
public class WorkingShiftDto {
    private Long shiftId;

    private Long employeeId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private String shiftType;
    private Status status;
}
