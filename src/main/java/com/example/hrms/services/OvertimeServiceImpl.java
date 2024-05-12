package com.example.hrms.services;

import com.example.hrms.dto.OvertimeDto;
import com.example.hrms.entities.Employee;
import com.example.hrms.entities.Overtime;
import com.example.hrms.form.OvertimeForm;
import com.example.hrms.repo.EmployeeRepository;
import com.example.hrms.repo.OvertimeRepository;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetListOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OvertimeServiceImpl implements OvertimeService {
    @Autowired
    OvertimeRepository overtimeRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public AddOutPut addEdit(OvertimeForm overtimeForm) throws Exception {
        try {
            if (overtimeForm.getEmployeeId() == null) {
                return new AddOutPut("Không tìm thấy nhân viên.", false);
            }
            Optional<Employee> employee = employeeRepository.findById(overtimeForm.getEmployeeId());
            if (employee.isEmpty()) {
                return new AddOutPut("Không tìm thấy nhân viên.", false);
            }
            if (overtimeForm.getId() == null) {
                //add
                List<Overtime> overtimeInDb = overtimeRepository.findByDate(overtimeForm.getDate());
                if (overtimeInDb.isEmpty()) {
                    Overtime overtime = mapOverTime(overtimeForm, employee.get());
                    overtimeRepository.save(overtime);
                    return new AddOutPut("Thêm thành công.", true);
                }
                return new AddOutPut("Nhân viên đã OT ngày " + overtimeForm.getDate() + " rồi.", false);
            } else {
                //update
                Optional<Overtime> overtime = overtimeRepository.findById(overtimeForm.getId());
                if (overtime.isEmpty()) {
                    return new AddOutPut("Không tìm thấy OT.", false);
                }
                overtime.get().setReason(overtimeForm.getReason());
                overtime.get().setStatus(overtimeForm.getStatus());
                overtime.get().setEmployee(employee.get());
                overtimeRepository.save(overtime.get());
                return new AddOutPut("Cập nhật thành công.", true);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public GetListOutput getAll(LocalDate startDate, LocalDate endDate) throws Exception {
        try {
            List<Overtime> otInDb = overtimeRepository.findByDateBetween(startDate, endDate);
            List<OvertimeDto> ot = otInDb.stream().map(
                    leave -> mapOtDto(leave)).collect(java.util.stream.Collectors.toList());
            return new GetListOutput("Thành công", 200, ot, (long) ot.size());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public GetListOutput getOTOfUser(Long employeeId) throws Exception {
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            if (employee.isEmpty()) {
                return new GetListOutput("Không tìm thấy nhân viên.", 404, null, 0L);
            }
            List<Overtime> otInDb = overtimeRepository.findByEmployee(employee.get());
            List<OvertimeDto> otDto = otInDb.stream().map(
                    ot -> mapOtDto(ot)).collect(java.util.stream.Collectors.toList());
            return new GetListOutput("Thành công", 200, otDto, (long) otDto.size());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Overtime mapOverTime(OvertimeForm overtimeForm, Employee employee) {
        Overtime overtime = new Overtime();
        overtime.setDate(overtimeForm.getDate());
        overtime.setEmployee(employee);
        overtime.setReason(overtimeForm.getReason());
        overtime.setStatus(overtimeForm.getStatus());
        return overtime;
    }


    private OvertimeDto mapOtDto(Overtime overtime) {
        return OvertimeDto.builder()
                .id(overtime.getId())
                .date(overtime.getDate())
                .reason(overtime.getReason())
                .status(overtime.getStatus())
                .employeeId(overtime.getEmployee().getId())
                .employeeName(overtime.getEmployee().getName())
                .build();
    }

}
