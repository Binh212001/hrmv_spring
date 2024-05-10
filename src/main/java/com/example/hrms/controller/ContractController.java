package com.example.hrms.controller;

import com.example.hrms.dto.ContractDto;
import com.example.hrms.form.ContractForm;
import com.example.hrms.repo.EmployeeRepository;
import com.example.hrms.services.ContractService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;
    @PostMapping("/add-edit")
    public ResponseEntity add(@RequestBody ContractForm contractForm) {
        try {
            AddOutPut addOutPut= contractService.saveContract(contractForm);
        return ResponseEntity.ok().body(addOutPut);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/id")
    public ResponseEntity getById(@RequestParam("employeeId") Long employeeId) {
        try {
            GetOutput addOutPut= contractService.getByEmployeeId(employeeId);
        return ResponseEntity.ok().body(addOutPut);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
