package com.example.hrms.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.hrms.entities.Department}
 */
@Value
public class DepartmentDto implements Serializable {
    Integer id;
    String departmentName;
    Integer managerId;
}