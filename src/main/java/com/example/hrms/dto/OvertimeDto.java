package com.example.hrms.dto;

import com.example.hrms.utils.BaseResponse;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
@Data
public class OvertimeDto extends BaseResponse {
    private Long overtimeId;
    private  String fullName;
    private  String department;
    private Long employeeId;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Double hours;
}
