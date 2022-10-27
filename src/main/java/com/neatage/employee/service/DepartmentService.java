package com.neatage.employee.service;

import java.util.List;

import com.neatage.employee.entity.Department;

public interface DepartmentService {
    Department getByDepartmentId(long departmentId);

    List<Department> getAllDepartments();

    Department saveDepartment(Department department);

    void deleteByDepartmentId(long departmentId);

    List<Department> getByCountryId(String countryId);
}
