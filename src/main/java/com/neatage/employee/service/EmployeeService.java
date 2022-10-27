package com.neatage.employee.service;

import java.util.List;

import com.neatage.employee.entity.Employee;

public interface EmployeeService {
    Employee getByEmployeeId(String employeeId);

    Employee getByEmail(String email);

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    void deleteByEmployeeId(String employeeId);

    void deleteByEmail(String email);

    List<Employee> getByManagerId(String managerId);

    List<Employee> getByDepartmentId(long departmentId);

    List<Employee> getByJobId(long jobId);
}
