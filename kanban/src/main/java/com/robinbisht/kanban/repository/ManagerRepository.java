package com.robinbisht.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robinbisht.kanban.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{
	Manager findByEmail(String email);
	Manager findByEmailAndPassword(String email,String password);
}
