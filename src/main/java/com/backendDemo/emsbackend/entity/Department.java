package com.backendDemo.emsbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees= new HashSet<>();

//    public Department(Long id, String departmentName, String departmentDescription) {
//        this.id = id;
//        this.departmentName = departmentName;
//        this.departmentDescription = departmentDescription;
////        this.employees= null;
//    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
