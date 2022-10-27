package com.neatage.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neatage.employee.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
	List<Job> findByMinSalaryGreaterThan(double minSalary);
	
	List<Job> findByMinSalaryLessThan(double minSalary);
	
	List<Job> findByMaxSalaryGreaterThan(double maxSalary);
	
	List<Job> findByMaxSalaryLessThan(double maxSalary);
	
	List<Job> findByJobTitleContainsIgnoreCase(String title);
}
