package com.jirafe.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Expose
	private Long id;
	
	@Expose
	private String lastName;
	
	@Expose
	private String firstName;
	
	@Expose
	private String mail;
	
	private String token;
	
	@OneToMany(mappedBy = "user")
	private List<TaskClocking> taskClockings;
	
	@OneToMany(mappedBy="manager")
	private List<Project> managedProjects;

	@ManyToMany(mappedBy="developers")
	private List<Project> developedProjects;

	public User() {
		super();
	}
	
	public User(String lastName, String firstName, String mail) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.mail = mail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<TaskClocking> getTaskClockings() {
		return taskClockings;
	}

	public void setTaskClockings(List<TaskClocking> taskClockings) {
		this.taskClockings = taskClockings;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}   
	
}
