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
@Table(name="dependents")
@Data
public class Dependent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final long dependentId;
	
	@NotBlank(message = "First name is mandatory")
	@Size(min = 2, max = 45)
	private String firstName;
	
	@NotBlank(message = "Last name is mandatory")
	@Size(min = 2, max = 45)
	private String lastname;
	
	@NotBlank(message = "Field relationship is mandatory")
	@Size(min = 2, max = 25)
	private String relationship;
	
	@NotBlank(message = "Field employeeId is mandatory")
	private String employeeId;
}
