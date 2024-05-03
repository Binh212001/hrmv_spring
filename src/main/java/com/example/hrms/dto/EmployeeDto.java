package com.example.hrms.dto;

import com.example.hrms.entities.ContactInformation;
import com.example.hrms.entities.Contract;
import com.example.hrms.utils.BaseResponse;
import lombok.Data;


import java.util.Date;
@Data
public class EmployeeDto extends BaseResponse {
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private Date hireDate;
    private Long departmentId;
    private Long positionId;
    private Contract contract;
    private String email;
    private String phoneNumber;
    private ContactInformation contactInformation;
}
