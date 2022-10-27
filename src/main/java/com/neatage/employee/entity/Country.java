package com.neatage.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "countries")
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Country {

	@Id
	@Size(min = 2, max = 2)
	private String countryId;

	@Size(min = 2, max = 45)
	@Column(unique = true)
	@NotBlank(message = "Field countryName is mandatory")
	private String countryName;

	@NotNull(message = "Field regionId is mandatory")
	private int regionId;
}
