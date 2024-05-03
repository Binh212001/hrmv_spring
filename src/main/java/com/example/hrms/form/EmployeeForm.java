package com.example.hrms.form;

import com.example.hrms.entities.ContactInformation;
import lombok.Data;

import java.util.Date;
@Data

public class EmployeeForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private Date hireDate;
    private Long departmentId;
    private Long positionId;
    private String email;
    private String phoneNumber;

}
