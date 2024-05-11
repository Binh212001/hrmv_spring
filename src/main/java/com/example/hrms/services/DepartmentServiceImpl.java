package com.example.hrms.services;

import com.example.hrms.entities.Department;
import com.example.hrms.form.DepartmentForm;
import com.example.hrms.repo.DepartmentRepository;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public GetOutput getDepartment() throws Exception {
        try {

            return new GetOutput("Thành công", 200, departmentRepository.findAll());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public AddOutPut addEdit(DepartmentForm departmentForm) throws Exception {
        try {
            if(departmentForm.getId() instanceof  Long){
                Optional<Department> department= departmentRepository.findById(departmentForm.getId());
                if(department.isEmpty()){
                    return  new AddOutPut("Không tìm thấy phòng ban.", false);
                }
                department.get().setDepartmentName(departmentForm.getDepartmentName());
                department.get().setManagerId(departmentForm.getManagerId());
                departmentRepository.save(department.get());
                return new AddOutPut("Cập nhật thành công.", true);
            }
            Department department = mapDepartment(departmentForm);
            departmentRepository.save(department);
            return new AddOutPut("Thêm thành công", true);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Department mapDepartment(DepartmentForm departmentForm) {
        Department department = new Department();
        department.setDepartmentName(departmentForm.getDepartmentName());
        department.setManagerId(departmentForm.getManagerId());
        return department;
    }

}
