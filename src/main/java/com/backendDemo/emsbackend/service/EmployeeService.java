package com.backendDemo.emsbackend.service;

import com.backendDemo.emsbackend.dto.DepartmentDto;
import com.backendDemo.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);

    EmployeeDto assignEmployeeDepartment(Long departmentId, Long employeeId);

}
