package com.robinbisht.kanban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.robinbisht.kanban.entity.Team;
import com.robinbisht.kanban.services.TeamService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(path="/team")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@GetMapping("")
	public List<Team> findAll(){
		return teamService.viewAllTeams();
	}
	
	@GetMapping("/{tid}")
	public Team findTeamById(@PathVariable("tid") Integer teamId) {
		return teamService.viewTeam(teamId);
	}
	@GetMapping("/{tid}/add-task/{task}")
	public Team addTask(@PathVariable("tid") Integer teamId,@PathVariable("task") Integer taskId) {
		return teamService.addTask(teamId, taskId);
	}
	@PostMapping(value = "/create",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Team> createteam(@RequestBody Team team) {
		Team teamCreated = teamService.addTeam(team);
		return ResponseEntity.ok(teamCreated);
	}
	@PutMapping("/{tid}/update")
    public ResponseEntity editTeam(@PathVariable("tid") Integer teamId,
                               @RequestBody Team team) {
		Team teamUpdated = teamService.updateTeam(teamId,team);
        return ResponseEntity.ok( teamUpdated );
    }
	@DeleteMapping("/{tid}/delete")
    public ResponseEntity deleteTeam(@PathVariable("tid") Integer teamId) {
		teamService.deleteTeam(teamId);
        return ResponseEntity.ok().build();
    }
	
}
