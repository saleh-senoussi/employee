package com.neatage.employee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neatage.employee.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
	List<Department> findByCountryId(String countryId);
}
