package com.neatage.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neatage.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	Optional<Employee> findByEmail(String email);

	void deleteByEmail(String email);

	List<Employee> findByManagerId(String managerId);

	List<Employee> findByDepartmentId(long departmentId);

	List<Employee> findByJobId(long jobId);
}
