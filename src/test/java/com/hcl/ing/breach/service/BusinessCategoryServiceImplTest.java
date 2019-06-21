package com.hcl.ing.breach.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.breach.dto.BusinessAreaDTO;
import com.hcl.ing.breach.dto.BusinessCategoryDTO;
import com.hcl.ing.breach.entity.BusinessArea;
import com.hcl.ing.breach.entity.BusinessCategory;
import com.hcl.ing.breach.repository.BusinessCategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class BusinessCategoryServiceImplTest {
@Mock
BusinessCategoryRepository businessCategoryRepository;
@InjectMocks
BusinessCategoryServiceImpl businessCategoryServiceImpl;

@Test
public void testGetCategories() {
	List<BusinessCategory> categoryList = new ArrayList<>();
	BusinessCategory businessCategory=new BusinessCategory();
	BusinessArea businessArea = new BusinessArea();
	businessArea.setAreaId(1L);
	businessArea.setAreaName("loan");
	businessCategory.setCategoryId(1L);
	businessCategory.setCategoryName("houseloan");
	businessCategory.setBusinessArea(businessArea);
	categoryList.add(businessCategory);
	Mockito.when(businessCategoryRepository.findByBusinessAreaAreaId(1L)).thenReturn(categoryList);
	List<BusinessCategoryDTO> categoryDtos=businessCategoryServiceImpl.getCategories(1L);
	Assert.assertEquals("houseloan",categoryDtos.get(0).getCategoryName());
	
	
}
}
