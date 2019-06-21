package com.hcl.ing.breach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ing.breach.entity.BusinessCategory;

@Repository
public interface BusinessCategoryRepository extends JpaRepository<BusinessCategory, Long> {
	
//	@Query("select * from ")
//	List<BusinessCategory> findCategoriesById(Long areaId);
	List<BusinessCategory> findByBusinessAreaAreaId(Long areaId);
		

}
