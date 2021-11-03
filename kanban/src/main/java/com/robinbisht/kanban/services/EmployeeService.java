package com.robinbisht.kanban.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robinbisht.kanban.entity.Employee;
import com.robinbisht.kanban.entity.Manager;
import com.robinbisht.kanban.entity.Team;
import com.robinbisht.kanban.repository.EmployeeRepository;
import com.robinbisht.kanban.repository.TeamRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	public List<Employee> viewAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee viewEmployeeById(Integer id) {
		return employeeRepository.findById(id).get();
	}
	public Employee viewEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
	public Employee viewEmployeeByEmailAndPassword(String email,String password) {
		return employeeRepository.findByEmailAndPassword(email,password);
	}
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void removeEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee removeEmployeeFromTeam(Integer empId,Integer teamId) {
		Employee employee = employeeRepository.findById(teamId).get();
		employee.setTeam(null);
		return employeeRepository.save(employee);
	}
	public Employee addEmployeeToTeam(Integer empId,Integer teamId) {
		Employee employee = employeeRepository.findById(empId).get();
		Team team = teamRepository.findById(teamId).get();
		employee.setTeam(team);
		return employeeRepository.save(employee);
	}
}
