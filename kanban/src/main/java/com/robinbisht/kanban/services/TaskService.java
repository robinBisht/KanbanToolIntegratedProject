package com.robinbisht.kanban.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robinbisht.kanban.entity.Task;
import com.robinbisht.kanban.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> viewAllTasks(){
		return taskRepository.findAll();
	}
	public Task viewTask(Integer taskId) {
		return taskRepository.findById(taskId).get();
	}
	public Task addTask(Task task){
		return taskRepository.save(task);
	}
	public void deleteTask(Integer id) {
		taskRepository.deleteById(id);
	}
	public Task updateTask(Task task, Integer taskId) {
		task.setTaskId(taskId);
		return taskRepository.save(task);
		
	}
}
