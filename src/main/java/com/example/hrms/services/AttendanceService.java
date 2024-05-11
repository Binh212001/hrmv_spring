package com.example.hrms.services;

import com.example.hrms.form.AttendanceForm;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;

import java.time.LocalDate;

public interface AttendanceService {
    AddOutPut addEdit(AttendanceForm attendanceForm) throws Exception;

    GetOutput getAttendanceOfUser(Long employeeId, LocalDate time) throws Exception;

    GetOutput getAttendanceList() throws Exception;
}
