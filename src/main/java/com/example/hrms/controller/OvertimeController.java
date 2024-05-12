package com.example.hrms.controller;

import com.example.hrms.form.OvertimeForm;
import com.example.hrms.services.OvertimeService;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetListOutput;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
@RestController
@RequestMapping("overtime")

public class OvertimeController {
    @Autowired
    OvertimeService overtimeService;


    @RequestMapping("add-edit")
    public ResponseEntity addEdit(@RequestBody OvertimeForm overtimeForm) {
        try {
            AddOutPut outPut = overtimeService.addEdit(overtimeForm);
            return ResponseEntity.ok(outPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AddOutPut(e.getMessage(), false));
        }
    }

    @RequestMapping("all")
    public ResponseEntity getAll(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        try {
            GetListOutput outPut = overtimeService.getAll(startDate,endDate);
            return ResponseEntity.ok(outPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GetOutput(e.getMessage(), 400,null));
        }
    }
    @RequestMapping("user")
    public ResponseEntity getAll(@RequestParam("employeeId") Long employeeId) {
        try {
            GetListOutput outPut = overtimeService.getOTOfUser(employeeId);
            return ResponseEntity.ok(outPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GetOutput(e.getMessage(), 400,null));
        }
    }
}
