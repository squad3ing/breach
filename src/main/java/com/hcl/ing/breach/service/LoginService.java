package com.hcl.ing.breach.service;

import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.EmployeeDTO;

@Service
public interface LoginService {

	EmployeeDTO login(Long loginId, String password);

}
