package com.example.hrms.controller;

import com.example.hrms.form.DepartmentForm;
import com.example.hrms.repo.DepartmentRepository;
import com.example.hrms.services.DepartmentService;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/get")
    public ResponseEntity getDepartment() {
        try {
            GetOutput output = departmentService.getDepartment();
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GetOutput(e.getMessage(), 400, null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity addDepartment(@RequestBody DepartmentForm departmentForm) {
        try {
            AddOutPut output = departmentService.addEdit(departmentForm);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GetOutput(e.getMessage(), 400, null));
        }
    }

}
