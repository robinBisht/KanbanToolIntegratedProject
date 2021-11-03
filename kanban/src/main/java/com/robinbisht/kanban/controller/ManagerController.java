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

import com.robinbisht.kanban.entity.Manager;
import com.robinbisht.kanban.entity.Team;
import com.robinbisht.kanban.services.ManagerService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(path="/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("")
	public List<Manager> findAll(){
		return managerService.viewAllManagers();
	}
	
	@GetMapping("/{mid}")
	public Manager findManagerById(@PathVariable("mid") Integer managerId) {
		return managerService.viewManagerById(managerId);
	}
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<Manager> loginManager(@PathVariable("email") String email,@PathVariable("password") String password ) throws Exception{
		Manager manager = managerService.viewManagerByEmailAndPassword(email, password);
		if(manager == null) throw new NoSuchElementException();
		return new ResponseEntity<Manager>(manager,HttpStatus.OK);
	}
	@PostMapping(value = "/create",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
		Manager ManagerCreated = managerService.addManager(manager);
		return ResponseEntity.ok(ManagerCreated);
	}
	@PutMapping("/{mid}/update")
    public ResponseEntity editManager(@PathVariable("eid") Integer managerId,
                               @RequestBody Manager manager) {
		manager.setManagerId(managerId);
		Manager managerUpdated = managerService.viewManagerById(managerId);
        return ResponseEntity.ok( managerUpdated);
    }
	@DeleteMapping("/{mid}/delete")
    public ResponseEntity deleteManager(@PathVariable("mid") Integer managerId) {
		Manager Manager = managerService.viewManagerById(managerId);
        managerService.removeManager(managerId);
        return ResponseEntity.ok().build();
    }
	
	@GetMapping("/{mid}/set-team/{tid}")
	public ResponseEntity<Team> addToTeam(@PathVariable("mid") Integer managerId,@PathVariable("tid") Integer teamId){
		Team setTeam = managerService.setTeam(managerId, teamId);
		return ResponseEntity.ok(setTeam);
	}
}
