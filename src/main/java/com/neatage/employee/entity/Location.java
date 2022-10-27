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
@Table(name="locations")
@Data
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final long locationId;
	
	@NotBlank(message = "Field streetAddress is mandatory")
	@Size(min = 2, max = 55)
	private String streetAddress;
	
	private String unitNumber;
	
	private String postalCode;
	
	private String province;
	
	@NotBlank(message = "Field countryId is mandatory")
	private String countryId;
}
