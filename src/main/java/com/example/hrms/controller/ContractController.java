package com.example.hrms.controller;

import com.example.hrms.dto.ContractDto;
import com.example.hrms.form.ContractForm;
import com.example.hrms.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService ;

    @GetMapping("/get")
    public ResponseEntity getContract() {
        try {
            List<ContractDto> contract = contractService.getListContract();
            return ResponseEntity.ok().body(contract);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/get/employee")
    public ResponseEntity getContractByEmployee(@RequestParam("employeeId") Long employeeId) {
        try {
            ContractDto contract = contractService.getContractByEmployee(employeeId);
            return ResponseEntity.ok().body(contract);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateContract(@RequestBody ContractForm contractForm){
        try {
            boolean contract = contractService.update(contractForm);
            return ResponseEntity.ok().body(contract);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity addContract(@RequestBody ContractForm contractForm){
        try {
            boolean contract = contractService.add(contractForm);
            return ResponseEntity.ok().body(contract);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
