package com.hcl.ing.breach.service;


import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.BreachDTO;
@Service
public interface BreachService {
	
	public BreachDTO updateBreach(long breachId,String status);

	public BreachDTO fetchBreachSummary(Long breachId);


}
