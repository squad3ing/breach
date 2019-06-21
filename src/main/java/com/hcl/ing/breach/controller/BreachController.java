package com.hcl.ing.breach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.breach.dto.BreachDTO;
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

}
