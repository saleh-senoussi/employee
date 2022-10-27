package com.neatage.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neatage.employee.entity.Department;
import com.neatage.employee.error.NotFoundException;
import com.neatage.employee.repository.DepartmentRepository;
import com.neatage.employee.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department getByDepartmentId(long departmentId) {
        Optional<Department> department = this.departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            return department.get();
        }

        throw new NotFoundException(HttpStatus.NOT_FOUND, "No department found for the given id");
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = (List<Department>) this.departmentRepository.findAll();
        return departments;
    }

    @Override
    public Department saveDepartment(Department Department) {
        return this.departmentRepository.save(Department);
    }

    @Override
    public void deleteByDepartmentId(long DepartmentId) {
        this.departmentRepository.deleteById(DepartmentId);
    }

    @Override
    public List<Department> getByCountryId(String countryId) {
        return this.departmentRepository.findByCountryId(countryId);
    }
}
