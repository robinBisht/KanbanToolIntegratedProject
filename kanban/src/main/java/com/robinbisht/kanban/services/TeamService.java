package com.robinbisht.kanban.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robinbisht.kanban.entity.Task;
import com.robinbisht.kanban.entity.Team;
import com.robinbisht.kanban.repository.TaskRepository;
import com.robinbisht.kanban.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Team> viewAllTeams(){
		return teamRepository.findAll();	
	}
	public Team addTeam(Team team) {
		return teamRepository.save(team);
	}
	public Team viewTeam(Integer id) {
		return teamRepository.findById(id).get();
	}
	public void deleteTeam(Integer id) {
		teamRepository.deleteById(id);
	}
	public Team updateTeam(Integer id,Team team) {
		team.setTeamId(id);
		return teamRepository.save(team);
	}
	public Team addTask(Integer teamId,Integer taskId) {
		Task task = taskRepository.findById(taskId).get();
		Team team = teamRepository.findById(teamId).get();
		team.setTask(task);
		return teamRepository.save(team);
	}
	
}
