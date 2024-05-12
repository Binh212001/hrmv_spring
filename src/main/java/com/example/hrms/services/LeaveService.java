package com.example.hrms.services;

import com.example.hrms.form.LeaveForm;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetListOutput;

import java.time.LocalDate;

public interface LeaveService {
    AddOutPut addEdit(LeaveForm leaveForm) throws Exception;

    GetListOutput getAll(LocalDate startDate, LocalDate endDate) throws Exception;

    GetListOutput getLeaveOfUser(Long employeeId) throws Exception;
}
