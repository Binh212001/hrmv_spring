package com.example.hrms.services;

import com.example.hrms.form.DepartmentForm;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;

public interface DepartmentService {
    GetOutput getDepartment() throws Exception;

     AddOutPut addEdit(DepartmentForm departmentForm) throws Exception;
}
