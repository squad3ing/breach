package com.hcl.ing.breach.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class BusinessCategory implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6114310303056600657L;
	@Id 
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long categoryId;
	private String categoryName;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="areaId")
	private BusinessArea businessArea;
	
}
