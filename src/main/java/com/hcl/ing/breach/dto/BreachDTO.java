
package com.hcl.ing.breach.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@NoArgsConstructor

@AllArgsConstructor
public class BreachDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Long assignedId;
	private String employeeName;
	private Date creationDate;
	private String status;
	private String description;

}
