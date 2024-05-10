package com.example.hrms.controller;

import com.example.hrms.form.EmployeeForm;
import com.example.hrms.services.EmployeeService;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService ;

    @RequestMapping("/add")
    public ResponseEntity add(@RequestBody EmployeeForm employeeForm) {
        try {
             AddOutPut addOutPut =   employeeService.add(employeeForm);
            return ResponseEntity.ok(addOutPut);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity add() {
        try {
            GetOutput getOutput =   employeeService.getAll();
            return ResponseEntity.ok(getOutput);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/department")
    public ResponseEntity getByDepartment(@RequestParam("departmentId") Long departmentId) {
        try {
            GetOutput getOutput =   employeeService.getEmployeeByDepartment(departmentId);
            return ResponseEntity.ok(getOutput);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
