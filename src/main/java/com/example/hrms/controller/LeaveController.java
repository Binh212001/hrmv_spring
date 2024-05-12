package com.example.hrms.controller;

import com.example.hrms.form.AttendanceForm;
import com.example.hrms.form.LeaveForm;
import com.example.hrms.services.LeaveService;
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
@RequestMapping("/leave/")
public class LeaveController {

    @Autowired
    LeaveService leaveService;


    @RequestMapping("add-edit")
    public ResponseEntity addEdit(@RequestBody LeaveForm leaveForm) {
        try {
            AddOutPut outPut = leaveService.addEdit(leaveForm);
            return ResponseEntity.ok(outPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AddOutPut(e.getMessage(), false));
        }
    }

    @RequestMapping("all")
    public ResponseEntity getAll(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        try {
            GetListOutput outPut = leaveService.getAll(startDate,endDate);
            return ResponseEntity.ok(outPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GetOutput(e.getMessage(), 400,null));
        }
    }
    @RequestMapping("user")
    public ResponseEntity getAll(@RequestParam("employeeId") Long employeeId) {
        try {
            GetListOutput outPut = leaveService.getLeaveOfUser(employeeId);
            return ResponseEntity.ok(outPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GetOutput(e.getMessage(), 400,null));
        }
    }


}
