package com.robinbisht.kanban.services;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.robinbisht.kanban.entity.manager;
import com.robinbisht.kanban.entity.Manager;
import com.robinbisht.kanban.entity.Team;
//import com.robinbisht.kanban.repository.managerRepository;
import com.robinbisht.kanban.repository.ManagerRepository;
import com.robinbisht.kanban.repository.TeamRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	public List<Manager> viewAllManagers(){
		return managerRepository.findAll();
	}
	public Manager viewManagerByEmail(String email) {
		return managerRepository.findByEmail(email);
	}
	public Manager viewManagerByEmailAndPassword(String email,String password) {
		return managerRepository.findByEmailAndPassword(email,password);
	}
	public Manager viewManagerById(Integer id) {
		return managerRepository.findById(id).get();
	}
	
	public Manager addManager(Manager manager) {
		return managerRepository.save(manager);
	}
	
	public void removeManager(Integer id) {
		managerRepository.deleteById(id);
	}
	
	public Team setTeam(Integer managerId, Integer teamId) {
		Manager manager = managerRepository.findById(managerId).get();
		Team team = teamRepository.findById(teamId).get();
		manager.setTeam(team);
		managerRepository.save(manager);
		return team;
	}
}
