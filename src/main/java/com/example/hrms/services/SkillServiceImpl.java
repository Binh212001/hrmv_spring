package com.example.hrms.services;

import com.example.hrms.dto.SkillDto;
import com.example.hrms.entities.Employee;
import com.example.hrms.entities.EmployeeSkill;
import com.example.hrms.entities.Skill;
import com.example.hrms.form.SkillForm;
import com.example.hrms.repo.EmployeeRepository;
import com.example.hrms.repo.EmployeeSkillRepository;
import com.example.hrms.repo.SkillRepository;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeSkillRepository employeeSkillRepository;

    @Override
    public GetOutput getSkills() throws Exception {
        try {
            List<Skill> skills = skillRepository.findAll();
            return new GetOutput("Thành công", 200, skills);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public AddOutPut saveSkill(SkillForm skillForm) throws Exception {
        try {
            if (skillForm.getId() instanceof  Long){
                //Update Skill
                Optional<Skill> skill = skillRepository.findById(skillForm.getId());
                if(skill.isEmpty()) {
                return new AddOutPut("Skill not found" , false);
                }
                skill.get().setSkillName(skillForm.getSkillName());
                skill.get().setDescription(skillForm.getDescription());
                skillRepository.save(skill.get());
                return new AddOutPut("Cập nhật thành công", true);
            }
            // Add skill
            Skill skill = mapToSkill(skillForm);
            skillRepository.save(skill);
            return new AddOutPut("Thêm thành công", true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public GetOutput getSkillEmployee(Long employeeId) throws Exception {
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            if (employee.isEmpty()) {
                return new GetOutput("Không tìm thấy nhân viên.", 400, null);
            }
            List<EmployeeSkill> skills = employeeSkillRepository.findByEmployee(employee.get());
            List<SkillDto> skillDtos = skills.stream().map(skill -> mapSkillToDto(skill.getSkill())).collect(java.util.stream.Collectors.toList());
            return new GetOutput("Thành công.", 200, skillDtos);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public AddOutPut addSkillEmployee(Long employeeId, Long skillId) throws Exception {
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            Optional<Skill> skill = skillRepository.findById(skillId);
            if (employee.isPresent() && skill.isPresent()) {
                EmployeeSkill employeeSkill = new EmployeeSkill();
                employeeSkill.setEmployee(employee.get());
                employeeSkill.setSkill(skill.get());
                employeeSkillRepository.save(employeeSkill);
                return new AddOutPut("Thêm thành công.", true);
            }
            return new AddOutPut("Nhân viên hoặc ký năng không tồn tại.", false);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Skill mapToSkill(SkillForm skillForm) {
        Skill skill = new Skill();
        skill.setSkillName(skillForm.getSkillName());
        skill.setDescription(skillForm.getDescription());
        return skill;
    }

    public SkillDto mapSkillToDto(Skill skill) {
        return SkillDto.builder()
                .id(skill.getId())
                .skillName(skill.getSkillName())
                .description(skill.getDescription())
                .build();
    }


}
