package com.jirafe.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jirafe.entities.Project;
import com.jirafe.entities.User;
import com.jirafe.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	UserServiceImpl userService;

	@Override
	public Project createProject(Project newProject, String token) {
		if (newProject != null) {
			newProject.setManager(userService.getUserByToken(token));
			newProject.setStartTime(new Date());
			newProject.setEndTime(new Date());

			projectRepository.save(newProject);

			return newProject;
		}

		return null;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projectList = new ArrayList<>();

		for (Project itemProject : projectRepository.findAll())
			projectList.add(itemProject);

		return projectList;
	}

	@Override
	public List<Project> getProjectsForUser(long idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getProject(long idProject) {
		return projectRepository.findOne(idProject);
	}
	
	@Override
	public boolean addDeveloper(Long projectId, String devMail) {
		Project project = getProject(projectId);
		List<User> users = userService.getUserByEmail(devMail);
		if(users == null || users.isEmpty())
			return false;
		if(project == null)
			return false;
		
		project.getDevelopers().add(users.get(0));
		projectRepository.save(project);
		return true;
	}	
}
