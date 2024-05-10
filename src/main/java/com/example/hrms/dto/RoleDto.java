package com.example.hrms.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.hrms.entities.Role}
 */
@Data
public class RoleDto implements Serializable {
    Long id;
    String roleName;
    String description;
}