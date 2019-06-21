package com.hcl.ing.breach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.breach.entity.BusinessCategory;

@Repository
public interface BusinessCategoryRepository extends JpaRepository<BusinessCategory, Long> {

}
