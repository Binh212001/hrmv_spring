package com.example.hrms.services;

import com.example.hrms.form.SkillForm;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;

public interface SkillService {
    GetOutput getSkills() throws Exception;
    AddOutPut saveSkill(SkillForm skillForm) throws Exception;

    GetOutput getSkillEmployee(Long employeeId) throws Exception;

    AddOutPut addSkillEmployee(Long employeeId, Long skillId) throws Exception;
}
