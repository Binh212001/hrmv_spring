package com.example.hrms.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.Department}
 */
@Getter
@Setter
public class EmployeeForm implements Serializable {
    Long id;
    String name;
    LocalDate dateOfBirth;
    String gender;
    String contactNumber;
    String email;
    String password;
    String address;
    LocalDate hireDate;
    LocalDate terminationDate;
    Long departmentId;
    Long positionId;
    Long contractId;
    Long skillId;



}