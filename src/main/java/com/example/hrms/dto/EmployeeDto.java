package com.example.hrms.dto;

import com.example.hrms.entities.Department;
import com.example.hrms.entities.Position;
import com.example.hrms.entities.Skill;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.hrms.entities.Employee}
 */
@Getter
@Setter
@Builder
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
    Department  department;
    Position position;
    Skill skill;
}