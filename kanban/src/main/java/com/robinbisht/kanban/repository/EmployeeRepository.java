package com.robinbisht.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robinbisht.kanban.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findByEmail(String email);
	Employee findByEmailAndPassword(String email,String password);
}
