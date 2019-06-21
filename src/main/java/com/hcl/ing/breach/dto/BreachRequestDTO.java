package com.hcl.ing.breach.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BreachRequestDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long employeeId;
	private String description;
	private String breachArea;
	private String breachCategory;

}
