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

import com.robinbisht.kanban.entity.Task;
import com.robinbisht.kanban.services.TaskService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(path="/task")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("")
	public List<Task> findAll(){
		return taskService.viewAllTasks();
	}
	
	@GetMapping("/{tid}")
	public Task findTaskById(@PathVariable("tid") Integer taskId) {
		return taskService.viewTask(taskId);
	}
	
	
	@PostMapping(value = "/create",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		Task taskCreated = taskService.addTask(task);
		return ResponseEntity.ok(taskCreated);
	}
	@PutMapping("/{tid}/update")
    public ResponseEntity editTask(@PathVariable("tid") Integer taskId,
                               @RequestBody Task task) {
		Task taskUpdated = taskService.updateTask(task, taskId);
        return ResponseEntity.ok( taskUpdated );
    }
	@DeleteMapping("/{tid}/delete")
    public ResponseEntity deleteTask(@PathVariable("tid") Integer taskId) {
		taskService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
}
