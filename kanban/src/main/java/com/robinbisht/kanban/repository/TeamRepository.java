package com.robinbisht.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robinbisht.kanban.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

}
