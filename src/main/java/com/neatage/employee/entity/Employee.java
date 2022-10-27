package com.neatage.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final String employeeId;

	@Column(unique = true)
	@NotBlank(message = "Email is mandatory")
	@Email
	private String email;

	@NotBlank(message = "First name is mandatory")
	@Size(min = 2, max = 45)
	private String firstName;

	private String middleName;

	@NotBlank(message = "Last name is mandatory")
	@Size(min = 2, max = 45)
	private String lastname;

	@Temporal(TemporalType.DATE)
	@NotBlank(message = "Birth date is mandatory")
	private Date birthDate;

	private String countryCode;

	@NotBlank(message = "Phone number is mandatory")
	private String phoneNumber;

	@NotBlank(message = "Phone type is mandatory")
	@Size(min = 2, max = 20)
	private String phoneType;

	private String phoneExtension;

	@NotBlank(message = "Hire date is mandatory")
	private String hireDate;

	@Temporal(TemporalType.DATE)
	@NotBlank(message = "Created date is mandatory")
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	private Date lastUpdatedDate;

	@NotBlank(message = "Job id is mandatory")
	private long jobId;

	@NotBlank(message = "Salary is mandatory")
	private double salary;

	private String managerId = "";

	@NotBlank(message = "Department id is mandatory")
	private long departmentId;

	@PrePersist
	public void prePersist() {
		this.createdDate = new Date();
		this.lastUpdatedDate = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.lastUpdatedDate = new Date();
	}
}
