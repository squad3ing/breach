package com.hcl.ing.breach.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Breach implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long breachId;
	private String businessArea;
	private String businessCategory;
	private String description;
	private Date creationDate;
	private String status;
	private String riskType;
	private Long assignedId;
	private Long creatorId;
	private String assigneeName;

}
