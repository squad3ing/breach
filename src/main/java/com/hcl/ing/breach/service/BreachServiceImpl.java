package com.hcl.ing.breach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.BreachDTO;
import com.hcl.ing.breach.entity.Breach;
import com.hcl.ing.breach.entity.Employee;
import com.hcl.ing.breach.repository.BreachRepository;
import com.hcl.ing.breach.repository.EmployeeRepository;
@Service
public class BreachServiceImpl implements BreachService{

	@Autowired
	private BreachRepository breachRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public BreachDTO updateBreach(long breachId,String status) {

		
		BreachDTO breachDTO=new BreachDTO();
		Breach breach= breachRepository.findById(breachId).get();
		breach.setStatus(status);
		breachDTO.setEmployeeId(breach.getCreatorId());
		Employee employee=employeeRepository.findById(breach.getCreatorId()).get();
		breachDTO.setEmployeeName(employee.getEmployeeName());
		breachDTO.setCreationDate(breach.getCreationDate());
		breachDTO.setDescription(breach.getDescription());
		breachDTO.setStatus(breach.getStatus());
		breachRepository.save(breach);
		return breachDTO;
	}



}
