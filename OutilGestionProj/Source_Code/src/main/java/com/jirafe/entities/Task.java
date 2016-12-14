package com.jirafe.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

@Entity
public class Task implements Serializable {
	
	public enum Status{
		TODO,
		WORK_IN_PROGRESS,
		SUSPENDED,
		DONE
	}
	
	public enum Priority{
		VERY_LOW,
		LOW,
		MEDIUM,
		HIGH,
		VERY_HIGH 
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private Long id;
	
	@Expose
	private String title;
	
	@Expose
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Expose
	private Status status;
	
	@Enumerated(EnumType.STRING)
	@Expose
	private Priority priority;
	
	@ManyToOne
	private Project project;
	
	@OneToMany (mappedBy = "task")
	private List<TaskClocking> taskCloking = new ArrayList<>();
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	public Task(String title, String description, Status status, Priority priority, Project project) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public List<TaskClocking> getTaskCloking() {
		return taskCloking;
	}

	public void setTaskCloking(List<TaskClocking> taskCloking) {
		this.taskCloking = taskCloking;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
