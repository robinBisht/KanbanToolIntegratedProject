package com.robinbisht.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robinbisht.kanban.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
