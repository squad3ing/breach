package com.hcl.ing.breach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.breach.dto.EmployeeDTO;
import com.hcl.ing.breach.dto.LoginDTO;
import com.hcl.ing.breach.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"} , origins = {"*","/"})
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/api/login")
	public ResponseEntity<EmployeeDTO> login (@RequestBody LoginDTO loginDTO){
		EmployeeDTO employeeDTO = loginService.login(loginDTO.getLoginId(),loginDTO.getPassword());
		return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
	}

}
