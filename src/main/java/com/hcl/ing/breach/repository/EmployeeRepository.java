package com.hcl.ing.breach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.breach.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	public Employee findByLoginIdAndPassword(Long loginId, String password) ;
	public Employee findByRole(String role);
}
