package com.hcl.ing.breach.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.EmployeeDTO;
import com.hcl.ing.breach.entity.Employee;
import com.hcl.ing.breach.repository.EmployeeRepository;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO login(Long loginId, String password) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		Employee employee = employeeRepository.findByLoginIdAndPassword(loginId, password);
		BeanUtils.copyProperties(employee, employeeDTO);
		return employeeDTO;		
	}

}
