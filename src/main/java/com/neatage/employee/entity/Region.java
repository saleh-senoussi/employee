package com.neatage.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name="regions")
@Data
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final int regionId;
	
	@NotBlank(message = "Field regionName is mandatory")
	private String regionName;
}
