package com.example.hrms.services;

import com.example.hrms.dto.AttendanceDto;
import com.example.hrms.dto.AttendanceListDto;
import com.example.hrms.entities.Attendance;
import com.example.hrms.entities.Employee;
import com.example.hrms.form.AttendanceForm;
import com.example.hrms.repo.AttendanceRepository;
import com.example.hrms.repo.EmployeeRepository;
import com.example.hrms.utils.AddOutPut;
import com.example.hrms.utils.GetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Autowired
    AttendanceRepository attendRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public AddOutPut addEdit(AttendanceForm attendanceForm) throws Exception {
        try {
            if (attendanceForm.getEmployeeId()== null){
                return new AddOutPut("Không tìm thấy nhân viên.", false);
            }
                Optional<Employee > employee = employeeRepository.findById(attendanceForm.getEmployeeId());
            if (employee.isEmpty()){
                return new AddOutPut("Không tìm thấy nhân viên.", false);
            }
            if(attendanceForm.getId() == null){
                //add
                List<Attendance> attendanceInDb = attendRepository.findByDate(attendanceForm.getDate() );
                if (attendanceInDb.isEmpty()) {
                Attendance attendance = mapAttendance(attendanceForm, employee.get());
                attendRepository.save(attendance);
                return new AddOutPut("Thêm thành công.", true);
                }
                return new AddOutPut("Nhân viên đã đi làm.", false);
            }else {
                //update
                Optional<Attendance> attendance = attendRepository.findById(attendanceForm.getId());
                if (attendance.isEmpty()){
                }
                attendance.get().setDate(attendanceForm.getDate());
                attendance.get().setClockInTime(attendanceForm.getClockInTime());
                attendance.get().setClockOutTime(attendanceForm.getClockOutTime());
                attendance.get().setEmployee(employee.get());
                attendRepository.save(attendance.get());
                return new AddOutPut("Cập nhật thành công.", true);
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public GetOutput getAttendanceOfUser(Long employeeId, LocalDate time) throws Exception {
       try {
           int dayOfMonth = time.lengthOfMonth();
           int month =  time.getMonthValue();
           int year =  time.getYear();
           LocalDate startDate = LocalDate.of(year, month,1);
           LocalDate endDate = LocalDate.of(year, month,dayOfMonth);
           Optional<Employee> employee = employeeRepository.findById(employeeId);
           if (employee.isEmpty()){
               return new GetOutput("Không tìm thấy nhân viên.", 400, null);
           }
           List<Object[]> attendances = attendRepository.findByEmployeeAndDateBetween(startDate,endDate,employeeId);
           List<AttendanceDto> attendanceDtos = attendances.stream().map(
                   a -> new AttendanceDto((Long) a[0], (Long) a[1],  Date.valueOf(a[2].toString()).toLocalDate(),
                           Time.valueOf(a[3].toString()).toLocalTime(),Time.valueOf(a[4].toString()).toLocalTime(),(String) a[5])
           ).collect(java.util.stream.Collectors.toList());
           return new GetOutput("Thành công.", 200, attendanceDtos);
       }catch (Exception e){
           throw new Exception(e.getMessage());
       }
    }

    @Override
    public GetOutput getAttendanceList() throws Exception {
        try {
            List<Object[]> objects = attendRepository.findEmploeeAteendance();
            List<AttendanceListDto> dtoList =  objects.stream().map(a->new AttendanceListDto(
            (Long) a[0],(String) a[1],(BigDecimal) a[2], (BigDecimal) a[3])
            ).collect(Collectors.toList());
            return new GetOutput("Danh sách cakip của nhân viên",200,dtoList);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }


    public Attendance mapAttendance(AttendanceForm attendanceForm , Employee e){
        Attendance attendance = new Attendance();
        attendance.setDate(attendanceForm.getDate());
        attendance.setEmployee(e);
        attendance.setClockInTime(attendanceForm.getClockInTime());
        attendance.setClockOutTime(attendanceForm.getClockOutTime());
        return attendance;

    }

}
