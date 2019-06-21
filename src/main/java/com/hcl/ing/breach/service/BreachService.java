package com.hcl.ing.breach.service;

import com.hcl.ing.breach.dto.BreachDTO;

public interface BreachService {

	BreachDTO fetchBreachSummary(Long breachId);

	//List<BreachDTO> fetchBreachSummary(Long breachId);

}
