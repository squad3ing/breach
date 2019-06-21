package com.hcl.ing.breach.dto;

import java.util.List;

import com.hcl.ing.breach.entity.BusinessCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@NoArgsConstructor
@ToString
public class BusinessAreaDTO {
	private Long areaId;
	private String areaName;
	private List<BusinessCategory> businessCategory;
}
