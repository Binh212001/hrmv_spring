package com.example.hrms.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.hrms.entities.Skill}
 */
@Data
@Builder
public class SkillDto implements Serializable {
    Long id;
    String skillName;
    String description;
}