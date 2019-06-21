
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.ing.breach.dto.BreachDTO;
import com.hcl.ing.breach.entity.Breach;
import com.hcl.ing.breach.repository.BreachRepository;

@RunWith(MockitoJUnitRunner.class)
public class BreachServiceImplTest {
	private static final Logger logger = LoggerFactory.getLogger(BreachServiceImplTest.class);

	@Mock
	BreachRepository breachRepository;

	@InjectMocks
	BreachServiceImpl breachServiceImpl;

	@Test
	public void fetchBreachSummaryTest() {
		List<Breach> list = new ArrayList<>();
		Breach breach = new Breach();
		breach.setAssignedId(1L);
		breach.setAssigneeName("ankit");
		breach.setDescription("hcl");
		Breach breach1 = new Breach();
		breach1.setAssignedId(1L);
		breach1.setAssigneeName("ankit");
		breach1.setDescription("hcl");
		list.add(breach);
		list.add(breach1);
		logger.debug("breach summary test");
		BreachDTO breachDTO = new BreachDTO();
		breachDTO.setAssignedId(1L);
		breachDTO.setDescription("status");
		Mockito.when(breachRepository.findByBreachId(1L)).thenReturn(list);
		breachDTO = breachServiceImpl.fetchBreachSummary(1L);
		Assert.assertEquals(1,breachDTO.getAssignedId());

	}
}
