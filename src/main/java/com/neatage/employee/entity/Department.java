package com.neatage.employee.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="departments")
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final long departmentId;
	
	@NotBlank(message = "Department name is mandatory")
	@Size(min = 2, max = 30)
	private String departmentName;
	
	@NotBlank(message = "Location id name is mandatory")
	private long locationId;
	
	@NotBlank(message = "Country id name is mandatory")
	private String countryId;
	
	@Temporal(TemporalType.DATE)
	@NotBlank(message = "Created date is mandatory")
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	private Date lastUpdatedDate;
	
	@NotBlank(message = "Last updated by is mandatory")
	@Size(min = 2, max = 45)
	private String lastUpdatedBy;
}
