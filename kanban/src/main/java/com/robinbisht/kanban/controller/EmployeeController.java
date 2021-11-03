package com.robinbisht.kanban.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robinbisht.kanban.entity.Employee;
import com.robinbisht.kanban.entity.Manager;
import com.robinbisht.kanban.services.EmployeeService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("")
	public List<Employee> findAll(){
		return employeeService.viewAllEmployee();
	}
	
	@GetMapping("/{eid}")
	public Employee findEmployeeById(@PathVariable("eid") Integer employeeId) {
		return employeeService.viewEmployeeById(employeeId);
	}
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<Employee> loginEmployee(@PathVariable("email") String email,@PathVariable("password") String password ) throws Exception{
		Employee employee = employeeService.viewEmployeeByEmailAndPassword(email, password);
		if(employee == null) throw new NoSuchElementException();
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	@PostMapping(value = "/create",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee employeeCreated = employeeService.addEmployee(employee);
		return ResponseEntity.ok(employeeCreated);
	}
	@PutMapping("/{eid}/update")
    public ResponseEntity editEmployee(@PathVariable("eid") Integer employeeId,
                               @RequestBody Employee employee) {
		employee.setEmployeeId(employeeId);
		Employee employeeUpdated = employeeService.viewEmployeeById(employeeId);
        return ResponseEntity.ok( employeeUpdated);
    }
	@DeleteMapping("/{eid}/delete")
    public ResponseEntity deleteEmployee(@PathVariable("eid") Integer employeeId) {
		Employee employee = employeeService.viewEmployeeById(employeeId);
        employeeService.removeEmployee(employeeId);
        return ResponseEntity.ok().build();
    }
	
	@GetMapping("/{eid}/add-to-team/{tid}")
	public ResponseEntity<Employee> addToTeam(@PathVariable("eid") Integer employeeId,@PathVariable("tid") Integer teamId){
		Employee employeeAdded = employeeService.addEmployeeToTeam(employeeId, teamId);
		return ResponseEntity.ok(employeeAdded);
	}
	
}
