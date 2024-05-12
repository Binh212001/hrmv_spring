package com.example.hrms.services;

import com.example.hrms.form.OvertimeForm;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetListOutput;

import java.time.LocalDate;

public interface OvertimeService {
    AddOutPut addEdit(OvertimeForm overtimeForm) throws Exception;

    GetListOutput getAll(LocalDate startDate, LocalDate endDate) throws Exception;

    GetListOutput getOTOfUser(Long employeeId) throws Exception;
}
