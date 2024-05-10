package com.example.hrms.repo;

import com.example.hrms.entities.Employee;
import com.example.hrms.entities.EmployeeSkill;
import com.example.hrms.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {
    List<EmployeeSkill> findByEmployee(Employee employee);
}