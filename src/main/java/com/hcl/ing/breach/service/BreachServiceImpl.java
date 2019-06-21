package com.hcl.ing.breach.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.BreachDTO;
import com.hcl.ing.breach.dto.BreachRequestDTO;
import com.hcl.ing.breach.entity.Breach;
import com.hcl.ing.breach.entity.Employee;
import com.hcl.ing.breach.entity.Rules;
import com.hcl.ing.breach.repository.BreachRepository;
import com.hcl.ing.breach.repository.EmployeeRepository;
import com.hcl.ing.breach.repository.RulesRepository;

@Service
public class BreachServiceImpl implements BreachService {

	private static final Logger logger = LoggerFactory.getLogger(BreachServiceImpl.class);
	@Autowired
	private BreachRepository breachRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	RulesRepository rulesRepository;

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
		breachDTO.setAssigneeName(breach.get(0).getAssigneeName());
		breachDTO.setBreachId(breach.get(0).getBreachId());
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

	@Override
	public BreachDTO raiseBreach(BreachRequestDTO breachRequestDTO) throws IllegalAccessException, InvocationTargetException {
		logger.info("INSIDE BREACH SERVICE IMPL");
		BreachDTO breachDTO = new BreachDTO();
		if(breachRequestDTO.getDescription()!=null) {
		Employee employee =employeeRepository.findById(breachRequestDTO.getEmployeeId()).orElse(null);
		System.out.println("EMPLOYEE : "+employee.getEmployeeId());
		Rules rule = rulesRepository.findByAreaNameAndCategoryName(breachRequestDTO.getBreachArea(), breachRequestDTO.getBreachCategory());
		System.out.println("RULE SIZE : "+rule.getRuleId());
		
		Employee assignee = employeeRepository.findByRole(rule.getRole());
		
		Breach breach = new Breach();
		breach.setAssignedId(assignee.getEmployeeId());
		breach.setAssigneeName(assignee.getEmployeeName());
		breach.setBusinessArea(rule.getAreaName());
		breach.setBusinessCategory(rule.getCategoryName());
		breach.setCreatorId(employee.getEmployeeId());
		breach.setCreationDate(new Date());
		breach.setDescription(breachRequestDTO.getDescription());
		breach.setRiskType(rule.getRiskType());
		breach.setStatus("InProgress");
		breach =	breachRepository.save(breach);
		breachDTO.setBreachId(breach.getBreachId());
		breachDTO.setStatus(breach.getStatus());
		breachDTO.setAssigneeName(breach.getAssigneeName());
		}else {
			//throw exception
		}
		
		
		return breachDTO;
	}

}
