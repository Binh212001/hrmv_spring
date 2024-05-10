package com.example.hrms.controller;

import com.example.hrms.form.SkillForm;
import com.example.hrms.repo.SkillRepository;
import com.example.hrms.services.SkillService;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skill")
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping("/get")
    public ResponseEntity getSkills() {
        try {
            GetOutput output = skillService.getSkills();
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add-edit")
    public ResponseEntity addSkill(@RequestBody SkillForm skillForm) {
        try {
            AddOutPut output = skillService.saveSkill(skillForm);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/employee")
    public ResponseEntity getSkillEmployee(@RequestParam("employeeId") Long employeeId) {
        try {
            GetOutput output = skillService.getSkillEmployee(employeeId);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/employee/add")
    public ResponseEntity addSkillEmployee(@RequestParam("employeeId") Long employeeId,
                                           @RequestParam("skillId") Long skillId)
    {
        try {
            AddOutPut addOutPut = skillService.addSkillEmployee(employeeId,skillId);
            return ResponseEntity.ok(addOutPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
