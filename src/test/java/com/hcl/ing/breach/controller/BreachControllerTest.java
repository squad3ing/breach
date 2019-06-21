package com.hcl.ing.breach.controller;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.ing.breach.dto.BreachDTO;
import com.hcl.ing.breach.service.BreachService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BreachController.class, secure = false)
public class BreachControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BreachService breachService;

	@Test
	public void studentRegistration() throws Exception {
		BreachDTO dto = new BreachDTO();
		dto.setAssignedId(1L);
		dto.setCreationDate(new Date());
		dto.setDescription("success");
		dto.setEmployeeName("ankit");
		dto.setStatus("approved");
		Mockito.when(breachService.fetchBreachSummary(Mockito.anyLong())).thenReturn(dto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/breaches/1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String InputType = this.mapToJson(dto);
		String OutputType = result.getResponse().getContentAsString();
		MockHttpServletResponse response = result.getResponse();
		System.out.println(OutputType.equals(InputType));

	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
