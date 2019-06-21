package com.hcl.ing.breach.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.BusinessAreaDTO;
import com.hcl.ing.breach.dto.BusinessCategoryDTO;
import com.hcl.ing.breach.entity.BusinessArea;
import com.hcl.ing.breach.entity.BusinessCategory;
import com.hcl.ing.breach.repository.BusinessCategoryRepository;

@Service
public class BusinessCategoryServiceImpl implements BusinessCategoryService{
@Autowired
BusinessCategoryRepository businessCategoryRepository;
	
	public List<BusinessCategoryDTO> getCategories(Long areaId) {
		List<BusinessCategoryDTO> businessCategoryDtos = new ArrayList<>();
		List<BusinessCategory> categoryList =(List<BusinessCategory>) businessCategoryRepository.findByBusinessAreaAreaId(areaId);
		for (BusinessCategory businessCategory : categoryList) {
			BusinessCategoryDTO businessCategoryDto = new BusinessCategoryDTO();
			businessCategoryDto.setCategoryId(businessCategory.getCategoryId());
			businessCategoryDto.setCategoryName(businessCategory.getCategoryName());
			businessCategoryDto.setBusinessArea(businessCategory.getBusinessArea());
			businessCategoryDtos.add(businessCategoryDto);
		}
		return businessCategoryDtos;
	}



}
