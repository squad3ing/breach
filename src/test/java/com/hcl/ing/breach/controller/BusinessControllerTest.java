package com.hcl.ing.breach.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.breach.dto.BusinessAreaDTO;
import com.hcl.ing.breach.dto.BusinessCategoryDTO;
import com.hcl.ing.breach.service.BusinessAreaService;
import com.hcl.ing.breach.service.BusinessCategoryService;

@RunWith(MockitoJUnitRunner.class)
public class BusinessControllerTest {
	@Mock
	BusinessAreaService businessAreaService;
	@Mock
	BusinessCategoryService businessCategoryService;

	@InjectMocks
	BusinessController businessController;

	List<BusinessAreaDTO> areaList;
	BusinessAreaDTO businessArea;
	List<BusinessAreaDTO> categoryList;
	BusinessCategoryDTO businessCategory;

	@Before
	public void setup() {
		areaList = new ArrayList<>();
		businessArea = new BusinessAreaDTO();
		categoryList = new ArrayList<>();
		businessCategory = new BusinessCategoryDTO();
		businessArea.setAreaId(1L);
		businessArea.setAreaName("loan");
		areaList.add(businessArea);
		businessCategory.setCategoryId(1L);
		businessCategory.setCategoryName("houseloan");

	}

	@Test
	public void testGetAreas() {

		Mockito.lenient().when(businessAreaService.getAreas()).thenReturn(areaList);
		Assert.assertEquals(areaList, businessController.getAreas().getBody());
	}

}
