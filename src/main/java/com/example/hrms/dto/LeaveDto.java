package com.example.hrms.dto;

import com.example.hrms.utils.BaseResponse;
import lombok.Data;

import java.util.Date;
@Data
public class LeaveDto extends BaseResponse {
    private Long leaveId;
    private  String fullName;
    private  String department;

    private Long employeeId;
    private String leaveType;
    private Date startDate;
    private Date endDate;
    private Double duration;
    private String reason;
}
