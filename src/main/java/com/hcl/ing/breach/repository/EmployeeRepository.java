package com.hcl.ing.breach.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ing.breach.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public Employee findByLoginIdAndPassword(Long loginId, String password) ;
}
