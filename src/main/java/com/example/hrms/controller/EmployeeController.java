package com.example.hrms.controller;

import com.example.hrms.dto.EmployeeDto;
import com.example.hrms.form.EmployeeForm;
import com.example.hrms.services.EmployeeService;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetListOutput;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
            GetListOutput getOutput =   employeeService.getAll();
            return ResponseEntity.ok(getOutput);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/id")
    public  ResponseEntity getEmployeeById (@RequestParam("employeeId") Long employeeId) {
        try {
            EmployeeDto employeeDto =   employeeService.getEmployeeById(employeeId);
            if (employeeDto  == null){
            return  ResponseEntity.badRequest().body("Không tìm thấy nhân viên có id: " + employeeId);
            }
            return ResponseEntity.ok().body(employeeDto);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/department")
    public ResponseEntity getByDepartment(@RequestParam("departmentId") Long departmentId) {
        try {
            GetListOutput getOutput =   employeeService.getEmployeeByDepartment(departmentId);
            return ResponseEntity.ok(getOutput);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search/id")
    public  ResponseEntity getEmployeeById (@RequestParam("name") String name) {
        try {
            GetListOutput employeeDto =   employeeService.getByName(name);

            return ResponseEntity.ok().body(employeeDto);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody EmployeeForm employeeForm) {
        try {
            AddOutPut addOutPut =   employeeService.update(employeeForm);
            return ResponseEntity.ok(addOutPut);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
