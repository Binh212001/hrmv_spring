package com.example.hrms.dto;

import com.example.hrms.entities.Role;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.hrms.entities.EmployeeRole}
 */
@Value
public class EmployeeRoleDto implements Serializable {
    EmployeeDto employee;
    Role role;
}