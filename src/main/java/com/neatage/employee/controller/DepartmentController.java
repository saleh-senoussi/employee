package com.neatage.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neatage.employee.entity.Department;
import com.neatage.employee.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable long departmentId) {
        Department department = this.departmentService.getByDepartmentId(departmentId);
        return ResponseEntity.ok().body(department);
    }

    @PostMapping()
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        Department savedDepartment = this.departmentService.saveDepartment(department);
        return ResponseEntity.ok().body(savedDepartment);
    }

    @GetMapping()
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = this.departmentService.getAllDepartments();
        return ResponseEntity.ok().body(departments);
    }

    @GetMapping("/all/{countryId}")
    public ResponseEntity<List<Department>> getDepartmentsByCountryId(@PathVariable String countryId) {
        List<Department> countries = this.departmentService.getByCountryId(countryId);
        return ResponseEntity.ok().body(countries);
    }

    @DeleteMapping("{departmentId}")
    public ResponseEntity<?> deleteByDepartmentId(@PathVariable long departmentId) {
        this.departmentService.deleteByDepartmentId(departmentId);
        return ResponseEntity.ok("Department with id: " + departmentId + " has been deleted");
    }
}
