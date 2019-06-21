package com.hcl.ing.breach.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.breach.dto.BusinessAreaDTO;
import com.hcl.ing.breach.entity.BusinessArea;
import com.hcl.ing.breach.repository.BusinessAreaRepository;

@RunWith(MockitoJUnitRunner.class)
public class BusinessAreaServiceImplTest {
	@Mock
	BusinessAreaRepository businessAreaRepository;
	@InjectMocks
	BusinessAreaServiceImpl businessAreaServiceImpl;

	@Test
	public void testGetAreas() {
		List<BusinessArea> areaList = new ArrayList<>();
		BusinessArea businessArea = new BusinessArea();
		businessArea.setAreaId(1L);
		businessArea.setAreaName("loan");
		areaList.add(businessArea);
		Mockito.when(businessAreaRepository.findAll()).thenReturn(areaList);
		List<BusinessAreaDTO> areaDtos = businessAreaServiceImpl.getAreas();
		Assert.assertEquals("loan", areaDtos.get(0).getAreaName());
	}

}
