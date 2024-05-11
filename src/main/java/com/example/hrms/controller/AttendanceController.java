package com.example.hrms.controller;

import com.example.hrms.form.AttendanceForm;
import com.example.hrms.services.AttendanceService;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("attendance/")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping("add-edit")
    public ResponseEntity addEdit(@RequestBody AttendanceForm attendanceForm) {
        try {
            AddOutPut outPut = attendanceService.addEdit(attendanceForm);
            return ResponseEntity.ok(outPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AddOutPut(e.getMessage(), false));
        }
    }

    @GetMapping("/user")
    public ResponseEntity getAttendanceOfUser(@RequestParam("employeeId" ) Long employeeId, @RequestParam("time") LocalDate time ) throws  Exception {
        try {
            GetOutput outPut = attendanceService.getAttendanceOfUser(employeeId , time);
            return ResponseEntity.ok(outPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AddOutPut(e.getMessage(), false));
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAttendances() throws  Exception {
        try {
            GetOutput outPut = attendanceService.getAttendanceList();
            return ResponseEntity.ok(outPut);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AddOutPut(e.getMessage(), false));
        }
    }
}
