package com.hcl.ing.breach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.breach.entity.Rules;

@Repository
public interface RulesRepository extends JpaRepository<Rules, Long>{

	public Rules findByAreaNameAndCategoryName(String areaName, String categoryName);
}
