package com.hcl.ing.breach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.breach.dto.BreachDTO;
import com.hcl.ing.breach.service.BreachService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class BreachController {
	@Autowired
	private BreachService breachService;

	@GetMapping("/breaches/{breachId}")
	public ResponseEntity<BreachDTO> getBreachSummary(@PathVariable Long breachId) {
		BreachDTO breachDTO = breachService.fetchBreachSummary(breachId);
		return new ResponseEntity<>(breachDTO, HttpStatus.OK);
	}

}
