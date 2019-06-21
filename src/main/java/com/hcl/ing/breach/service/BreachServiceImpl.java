package com.hcl.ing.breach.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.BreachDTO;
import com.hcl.ing.breach.entity.Breach;
import com.hcl.ing.breach.entity.Employee;
import com.hcl.ing.breach.repository.BreachRepository;
import com.hcl.ing.breach.repository.EmployeeRepository;

@Service
public class BreachServiceImpl implements BreachService {

	private static final Logger logger = LoggerFactory.getLogger(BreachServiceImpl.class);
	@Autowired
	private BreachRepository breachRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public BreachDTO fetchBreachSummary(Long breachId) {
		logger.info("fetch breach Summary");
		List<Breach> breach = breachRepository.findByBreachId(breachId);
		BreachDTO breachDTO = new BreachDTO();
		// create breachDto object
		breachDTO.setAssignedId(breach.get(0).getAssignedId());
		breachDTO.setEmployeeName(breach.get(0).getAssigneeName());
		breachDTO.setCreationDate(breach.get(0).getCreationDate());
		breachDTO.setStatus(breach.get(0).getStatus());
		breachDTO.setDescription(breach.get(0).getDescription());
		logger.info("return breachDTO");
		return breachDTO;
	}// method

	@Override
	public BreachDTO updateBreach(long breachId, String status) {

		BreachDTO breachDTO = new BreachDTO();
		Breach breach = breachRepository.findById(breachId).get();
		breach.setStatus(status);
		breachDTO.setAssignedId(breach.getCreatorId());
		Employee employee = employeeRepository.findById(breach.getCreatorId()).get();
		breachDTO.setEmployeeName(employee.getEmployeeName());
		breachDTO.setCreationDate(breach.getCreationDate());
		breachDTO.setDescription(breach.getDescription());
		breachDTO.setStatus(breach.getStatus());
		breachRepository.save(breach);
		return breachDTO;
	}

}
