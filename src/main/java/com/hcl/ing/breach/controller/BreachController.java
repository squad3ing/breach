package com.hcl.ing.breach.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.breach.dto.BreachDTO;
import com.hcl.ing.breach.dto.BreachRequestDTO;
import com.hcl.ing.breach.service.BreachService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"} , origins = {"*","/"})
@RequestMapping("/api")
public class BreachController {
	
	@Autowired
	private BreachService breachService;
	
	@PutMapping("/breach/breachId/{breachId}/status/{status}")
	public BreachDTO updateBreach(@PathVariable long breachId,@PathVariable String status )
	{
		BreachDTO breachDTO=breachService.updateBreach(breachId,status);
		return breachDTO;
	}
	
	@PostMapping("/breach")
	public ResponseEntity<BreachDTO> breach(@RequestBody BreachRequestDTO breachRequestDTO) throws IllegalAccessException, InvocationTargetException{
		
		BreachDTO breachDTO = breachService.raiseBreach(breachRequestDTO);
		
		return new ResponseEntity<>(breachDTO,HttpStatus.CREATED);
	}

}
