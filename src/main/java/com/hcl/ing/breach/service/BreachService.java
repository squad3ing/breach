package com.hcl.ing.breach.service;


import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.BreachDTO;
import com.hcl.ing.breach.dto.BreachRequestDTO;
@Service
public interface BreachService {
	
	public BreachDTO updateBreach(long breachId,String status);


	BreachDTO raiseBreach(BreachRequestDTO breachRequestDTO) throws IllegalAccessException, InvocationTargetException;
	public BreachDTO fetchBreachSummary(Long breachId);


}
