package com.hcl.ing.breach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.BusinessAreaDTO;
import com.hcl.ing.breach.repository.BusinessAreaRepository;

@Service
public class BusinessAreaServiceImpl implements BusinessAreaService{
@Autowired
BusinessAreaRepository businessAreaRepository;
	
	public List<BusinessAreaDTO> getAreas() {
		
		businessAreaRepository.findAll();
	}

}
