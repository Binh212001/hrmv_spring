package com.example.hrms.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.Employee}
 */
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto implements Serializable {
    Long id;
    String name;
    LocalDate dateOfBirth;
    String gender;
    String contactNumber;
    String email;
    String address;
    LocalDate hireDate;
    LocalDate terminationDate;
    Long departmentId;
    String departmentName;
    Long positionId;
    String positionName;

}