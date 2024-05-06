package com.example.hrms.controller;

import com.example.hrms.dto.EmployeeDto;
import com.example.hrms.form.EmployeeForm;
import com.example.hrms.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;
    @GetMapping("/get")
    public ResponseEntity getEmployee(@RequestParam("roleId") Long roleId) {

         try {
             List<EmployeeDto> employees = employeeService.getEmployees(roleId);
             return ResponseEntity.ok().body(employees);

         }catch ( Exception e ) {
             return ResponseEntity.badRequest().body(e.getMessage());
         }
    }

    @GetMapping("/get/id")
    public ResponseEntity getEmployeeById(@RequestParam("employeeId") Long employeeId) {

        try {
            List<EmployeeDto> e = employeeService.getEmployeeById(employeeId);
            if(e.size() == 0){
                return ResponseEntity.badRequest().body("Không rìm thấy employee " + employeeId);
            }
            return ResponseEntity.ok().body(e.get(0));
        }catch ( Exception e ) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/get/fullName")
    public ResponseEntity getEmployeeByFullName(@RequestParam("fullName") String fullName) {

        try {
            List<EmployeeDto> e = employeeService.getEmployeeByFullName(fullName);
            return ResponseEntity.ok().body(e);
        }catch ( Exception e ) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/department")
    public ResponseEntity getEmployeeAtDepartment(@RequestParam("departmentId") Long departmentId) {

        try {
            List<EmployeeDto> e = employeeService.getEmployeeAtDepartment(departmentId);
            return ResponseEntity.ok().body(e);
        }catch ( Exception e ) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public  ResponseEntity create(@RequestBody EmployeeForm employeeForm){
        try {
            boolean e = employeeService.create(employeeForm);
            return ResponseEntity.ok().body(e);
        }catch ( Exception e ) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public  ResponseEntity update(@RequestBody EmployeeForm employeeForm){
        try {
            boolean e = employeeService.update(employeeForm);
            return ResponseEntity.ok().body(e);
        }catch ( Exception e ) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
