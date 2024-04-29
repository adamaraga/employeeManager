package com.backendDemo.emsbackend.repository;


import com.backendDemo.emsbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query( value = "SELECT CASE WHEN EXISTS(SELECT 1 FROM departments AS counts) THEN 1 ELSE 0 END", nativeQuery = true)
    int checkIfTableExist();
}
