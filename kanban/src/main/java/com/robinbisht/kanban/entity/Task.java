package com.robinbisht.kanban.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	private String taskName;
	private LocalDate taskAssignedDate;
	private LocalDate taskSubmissionDate;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "task")
	private Team team;
	
	public Task() {
		
	}
	
	public Task(String taskName, LocalDate taskAssignedDate, LocalDate taskSubmissionDate) {
		this.taskName = taskName;
		this.taskAssignedDate = taskAssignedDate;
		this.taskSubmissionDate = taskSubmissionDate;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public LocalDate getTaskAssignedDate() {
		return taskAssignedDate;
	}
	public void setTaskAssignedDate(LocalDate taskAssignedDate) {
		this.taskAssignedDate = taskAssignedDate;
	}
	public LocalDate getTaskSubmissionDate() {
		return taskSubmissionDate;
	}
	public void setTaskSubmissionDate(LocalDate taskSubmissionDate) {
		this.taskSubmissionDate = taskSubmissionDate;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
}
