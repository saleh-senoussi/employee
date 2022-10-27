package com.neatage.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neatage.employee.entity.Employee;
import com.neatage.employee.error.NotFoundException;
import com.neatage.employee.repository.EmployeeRepository;
import com.neatage.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getByEmployeeId(String employeeId) {
        Optional<Employee> employee = this.employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            return employee.get();
        }

        throw new NotFoundException(HttpStatus.NOT_FOUND, "No employee found for the given id");
    }

    @Override
    public Employee getByEmail(String email) {
        Optional<Employee> employee = this.employeeRepository.findByEmail(email);
        if (employee.isPresent()) {
            return employee.get();
        }

        throw new NotFoundException(HttpStatus.NOT_FOUND, "No employee found for the given email");
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteByEmployeeId(String employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }

    @Override
    public void deleteByEmail(String email) {
        this.employeeRepository.deleteByEmail(email);
    }

    @Override
    public List<Employee> getByManagerId(String managerId) {
        return this.employeeRepository.findByManagerId(managerId);
    }

    @Override
    public List<Employee> getByDepartmentId(long departmentId) {
        return this.employeeRepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<Employee> getByJobId(long jobId) {
        return this.employeeRepository.findByJobId(jobId);
    }
}
