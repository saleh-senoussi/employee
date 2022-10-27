package com.neatage.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="jobs")
@Data
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final long jobId;
	
	@NotBlank(message = "Field jobTitle is mandatory")
	@Size(min = 2, max = 35)
	private String jobTitle;
	
	@NotBlank(message = "Field jobDescription is mandatory")
	@Size(min = 2, max = 450)
	private String jobDescription;
	
	@NotBlank(message = "Field minSalary is mandatory")
	private double minSalary;
	
	@NotBlank(message = "Field maxSalary is mandatory")
	private double maxSalary;
}
