package com.example.hrms.services;

import com.example.hrms.dto.ContractDto;
import com.example.hrms.form.ContractForm;

import java.util.List;

public interface ContractService {
    List<ContractDto> getListContract() throws  Exception;

    ContractDto getContractByEmployee(Long employeeId) throws Exception;

    boolean update(ContractForm contractForm) throws Exception;

    boolean add(ContractForm contractForm) throws  Exception;
}
