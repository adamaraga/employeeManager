package com.backendDemo.emsbackend.service;


import com.backendDemo.emsbackend.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);

    void deleteDepartment(Long departmentId);

    DepartmentDto assignEmployeeDepartment(Long departmentId, Long employeeId);


}
