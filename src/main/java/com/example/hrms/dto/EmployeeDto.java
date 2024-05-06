package com.example.hrms.dto;

import com.example.hrms.entities.ContactInformation;
import com.example.hrms.entities.Contract;
import com.example.hrms.entities.Role;
import com.example.hrms.utils.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private Date hireDate;
    private Long departmentId;
    private Long positionId;
    private String email;
    private String phoneNumber;
    private  Long roleId;
    private  String imageUrl;
    private  String roleName;
}
