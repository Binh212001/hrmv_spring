package com.example.hrms.dto;

import com.example.hrms.utils.BaseResponse;
import lombok.Data;

@Data
public class DepartmentDto extends BaseResponse {
    private Long departmentId;
    private  String fullName;
    private  String position;
    private Long employeeId;
    private String email;
    private String phoneNumber;
    private String address;
}
