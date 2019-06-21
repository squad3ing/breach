package com.hcl.ing.breach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.breach.dto.BreachDTO;
import com.hcl.ing.breach.entity.Breach;

@Repository
public interface BreachRepository extends JpaRepository<Breach, Long> {
	
	public BreachDTO raiseBreach(BreachDTO breachDTO);

}
