package com.neatage.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neatage.employee.entity.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long> {
	List<Dependent> findByEmployeeId(String employeeId);
}
