package com.jirafe.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

@Entity
public class Project implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private Long id;
	
	@Expose
	private Date startTime;
	
	@Expose
	private Date endTime;
	
	@Expose
	private String title;
	
	@Expose
	private String description;
	
	@OneToMany(mappedBy="project")
	@Expose
	private List<Task> tasks = new ArrayList<>();
	
	@ManyToOne
	@Expose
	private User manager;
	
	@ManyToMany
	@Expose
	private List<User> developers;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(Date startTime, Date endTime, String title, String description, User manager) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.description = description;
		this.manager = manager;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public List<User> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<User> developers) {
		this.developers = developers;
	}
	
}
