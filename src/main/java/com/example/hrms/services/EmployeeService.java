package com.example.hrms.services;

import com.example.hrms.form.EmployeeForm;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;

public interface EmployeeService {
    AddOutPut add(EmployeeForm employeeForm) throws Exception;

    GetOutput getAll() throws Exception;

    GetOutput getEmployeeByDepartment(Long departmentId)throws Exception;
}
