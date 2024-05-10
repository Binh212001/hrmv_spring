package com.example.hrms.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.hrms.entities.Skill}
 */
@Value
public class SkillDto implements Serializable {
    Integer id;
    String skillName;
    String description;
}