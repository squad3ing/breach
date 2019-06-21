package com.hcl.ing.breach.service;

import java.util.List;

import com.hcl.ing.breach.dto.BusinessCategoryDTO;

public interface BusinessCategoryService {

	List<BusinessCategoryDTO> getCategories(Long areaId);

}
