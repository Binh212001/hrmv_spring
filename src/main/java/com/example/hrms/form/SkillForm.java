package com.example.hrms.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SkillForm {
    Long id;
    String skillName;
    String description;
}
