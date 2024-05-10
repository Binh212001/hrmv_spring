package com.example.hrms.services;

import com.example.hrms.dto.ContractDto;
import com.example.hrms.entities.Contract;
import com.example.hrms.entities.Employee;
import com.example.hrms.form.ContractForm;
import com.example.hrms.repo.ContractRepository;
import com.example.hrms.repo.EmployeeRepository;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ContractRepository contractRepository;
    @Transactional
    @Override
    public AddOutPut saveContract(ContractForm contractForm) throws Exception {
        try {
            Optional<Employee> employee = employeeRepository.findById(contractForm.getEmployeeId());
            if(contractForm.getId() instanceof Long){
                if(employee.isEmpty()){
                    return  new AddOutPut("Không tìm thấy nhân viên.", false);
                }
                Optional<Contract> contract = contractRepository.findById(contractForm.getId());
                if(contract.isEmpty()){
                    return  new AddOutPut("Không tìm thấy hợp đồng.", false);
                }
                contract.get().setContractType(contractForm.getContractType());
                contract.get().setStartDate(contractForm.getStartDate());
                contract.get().setEndDate(contractForm.getEndDate());
                contract.get().setSalary(contractForm.getSalary());
                contractRepository.save(contract.get());
                return new AddOutPut("Cập nhật thành công.", true);
            }
            Contract contract = new Contract();
            contract.setContractType(contractForm.getContractType());
            contract.setStartDate(contractForm.getStartDate());
            contract.setEndDate(contractForm.getEndDate());
            contract.setSalary(contractForm.getSalary());
            contractRepository.save(contract);
            employee.get().setContract(contract);
            employeeRepository.save(employee.get());
            return new AddOutPut("Thêm thành công.", true);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public GetOutput getByEmployeeId(Long employeeId) throws Exception {
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            if(employee.isPresent()){
                Optional<Contract> contract = contractRepository.findById(employee.get().getContract().getId());
                if(contract.isPresent()){
                   ContractDto contractDto = mapContractDto(contract.get(), employee.get());
                    return  new GetOutput("Thành công",200,contractDto);
                }
                return  new GetOutput("Nhân viên không chính xác",400,null);
            }
            return  new GetOutput("Nhân viên không chính xác",400,null);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public  ContractDto mapContractDto(Contract contract, Employee employee){
        return ContractDto.builder()
                .id(contract.getId())
                .contractType(contract.getContractType())
                .startDate(contract.getStartDate())
                .endDate(contract.getEndDate())
                .salary(contract.getSalary())
                .employeeName(employee.getName())
                .build();
    }

}
