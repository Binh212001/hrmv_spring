package com.example.hrms.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.hrms.entities.Role}
 */
@Value
public class RoleDto implements Serializable {
    Integer id;
    String roleName;
    String description;
}