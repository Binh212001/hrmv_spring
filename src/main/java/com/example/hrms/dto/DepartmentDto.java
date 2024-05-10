package com.example.hrms.dto;

import lombok.Data;

/**
 * DTO for {@link com.example.hrms.entities.Department}
 */
@Data
public class DepartmentDto  {
    Long id;
    String departmentName;
    Integer managerId;
}