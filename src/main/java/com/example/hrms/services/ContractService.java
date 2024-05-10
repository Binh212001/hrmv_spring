package com.example.hrms.services;

import com.example.hrms.dto.ContractDto;
import com.example.hrms.form.ContractForm;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;

public interface ContractService {
    AddOutPut saveContract(ContractForm contractForm) throws Exception;

    GetOutput getByEmployeeId(Long id) throws Exception;
}
