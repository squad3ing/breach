package com.hcl.ing.breach.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.breach.dto.BusinessAreaDTO;
import com.hcl.ing.breach.entity.BusinessArea;
import com.hcl.ing.breach.repository.BusinessAreaRepository;

@Service
public class BusinessAreaServiceImpl implements BusinessAreaService {
	@Autowired
	BusinessAreaRepository businessAreaRepository;

	public List<BusinessAreaDTO> getAreas() {
		List<BusinessAreaDTO> businessAreaDtos = new ArrayList<>();
		List<BusinessArea> areaList = businessAreaRepository.findAll();
		for (BusinessArea businessArea : areaList) {
			BusinessAreaDTO businessAreaDTO = new BusinessAreaDTO();
			businessAreaDTO.setAreaId(businessArea.getAreaId());
			businessAreaDTO.setAreaName(businessArea.getAreaName());
			businessAreaDTO.setBusinessCategory(businessArea.getBusinessCategory());
			businessAreaDtos.add(businessAreaDTO);

		}
		return businessAreaDtos;
	}

}
