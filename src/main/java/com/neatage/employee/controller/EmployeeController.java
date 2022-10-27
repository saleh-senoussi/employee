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

import com.neatage.employee.entity.Employee;
import com.neatage.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId) {
        Employee employee = this.employeeService.getByEmployeeId(employeeId);
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        Employee employee = this.employeeService.getByEmail(email);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = this.employeeService.saveEmployee(employee);
        return ResponseEntity.ok().body(savedEmployee);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = this.employeeService.getAllEmployees();
        return ResponseEntity.ok().body(employees);
    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity<?> deleteByEmployeeId(@PathVariable String employeeId) {
        this.employeeService.deleteByEmployeeId(employeeId);
        return ResponseEntity.ok("Employee with id: " + employeeId + " has been deleted");
    }

    @DeleteMapping("email/{employeeId}")
    public ResponseEntity<?> deleteByEmail(@PathVariable String email) {
        this.employeeService.deleteByEmail(email);
        return ResponseEntity.ok("Employee with email: " + email + " has been deleted");
    }

    @GetMapping("/all/{managerId}")
    public ResponseEntity<List<Employee>> getEmployeesByEmployeeId(@PathVariable String managerId) {
        List<Employee> employees = this.employeeService.getByManagerId(managerId);
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/all/{departmentId}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentId(@PathVariable long departmentId) {
        List<Employee> employees = this.employeeService.getByDepartmentId(departmentId);
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/all/{jobId}")
    public ResponseEntity<List<Employee>> getEmployeesByJobId(@PathVariable long jobId) {
        List<Employee> employees = this.employeeService.getByJobId(jobId);
        return ResponseEntity.ok().body(employees);
    }
}
