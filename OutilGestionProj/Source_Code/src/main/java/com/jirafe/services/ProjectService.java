package com.jirafe.services;

import java.util.List;

import com.jirafe.entities.Project;

public interface ProjectService
{
	// Create / Modify / Delete
	Project createProject(Project newProject, String token);
	
	// Get informations about project
	List<Project> getAllProjects();
	List<Project> getProjectsForUser(long idUser);
	Project getProject(long idProject);
	
	boolean addDeveloper(Long projectId, String devMail);
}
