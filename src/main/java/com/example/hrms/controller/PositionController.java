package com.example.hrms.controller;

import com.example.hrms.form.DepartmentForm;
import com.example.hrms.form.PositionForm;
import com.example.hrms.services.DepartmentService;
import com.example.hrms.services.PositionService;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("position")
// the below code fragment can be found in:
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("/get")
    public ResponseEntity getDepartment() {
        try {
            GetOutput output = positionService.getPosition();
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GetOutput(e.getMessage(), 400, null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity addDepartment(@RequestBody PositionForm positionForm) {
        try {
            AddOutPut output = positionService.addEdit(positionForm);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GetOutput(e.getMessage(), 400, null));
        }
    }
}
