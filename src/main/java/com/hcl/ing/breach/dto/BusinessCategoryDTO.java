package com.hcl.ing.breach.dto;

import java.util.List;

import com.hcl.ing.breach.entity.BusinessArea;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter 
@NoArgsConstructor
@ToString
public class BusinessCategoryDTO {
	private Long categoryId;
	private String categoryName;
	private BusinessArea businessArea;
}
