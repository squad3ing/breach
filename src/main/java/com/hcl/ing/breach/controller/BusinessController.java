package com.hcl.ing.breach.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.breach.dto.BusinessAreaDTO;
import com.hcl.ing.breach.dto.BusinessCategoryDTO;
import com.hcl.ing.breach.service.BusinessAreaService;
import com.hcl.ing.breach.service.BusinessCategoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*","/"} , origins = {"*","/"})
public class BusinessController {
	private static final Logger lOGGER = LoggerFactory.getLogger(BusinessController.class);
@Autowired
BusinessAreaService businessAreaService;
@Autowired
BusinessCategoryService businessCategoryService;

@GetMapping("/businessareas")
public ResponseEntity<List<BusinessAreaDTO>> getAreas() {
	List<BusinessAreaDTO> areas = businessAreaService.getAreas();
	lOGGER.info("fetching...");
	return new ResponseEntity<>(areas, HttpStatus.OK);

}
@GetMapping("/businesscategories/{areaId}")
public ResponseEntity<List<BusinessCategoryDTO>> getCategories(@PathVariable Long areaId) {
	List<BusinessCategoryDTO> categories = businessCategoryService.getCategories(areaId);
	return new ResponseEntity<>(categories, HttpStatus.OK);

}

	
}
