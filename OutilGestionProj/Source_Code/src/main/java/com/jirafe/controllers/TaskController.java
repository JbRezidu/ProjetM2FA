package com.jirafe.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jirafe.entities.Project;
import com.jirafe.entities.Task;
import com.jirafe.services.JsonConverter;
import com.jirafe.services.ProjectServiceImpl;
import com.jirafe.services.TaskServiceImpl;

@Controller
@RequestMapping("/task")
public class TaskController {
	

	@Autowired
	private TaskServiceImpl taskService;
	
	@Autowired
	private ProjectServiceImpl projectService;
	
	@Autowired
	private JsonConverter jsonConverter;
	
	//Cr�ation d'une t�che pour un projet donn�e
	@RequestMapping(value ="/create", method=RequestMethod.POST)
	public void createTask(HttpServletRequest request, HttpServletResponse response, @RequestParam(name="projectId") long id){
		String json = "";
		try {
			String line;
			while((line = request.getReader().readLine()) != null)
				json += line;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Task task = jsonConverter.taskFromJson(json);
		Project project = projectService.getProject(id);
		task.setProject(project);
		taskService.createTask(task);;
		try {
			response.getWriter().write(jsonConverter.JSON_OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Retourne toutes les t�ches li�es � un projet
	@RequestMapping(value = "/tasks", method=RequestMethod.POST)
	public void getAllTasks(@RequestParam(name="projectId") long id, HttpServletResponse response){
		try {
			response.getWriter().write(jsonConverter.toJson(taskService.getTasksByProject(id)));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	//Retourne les informations d'une t�che 
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public void getTask(@RequestParam(name="taskId") long id, HttpServletResponse response){
		try {
			response.getWriter().write(jsonConverter.toJson(taskService.getTask(id)));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
			
	//Supprime une t�che
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteTask(@RequestParam(name="taskId") long id, HttpServletResponse response){
		taskService.deleteTask(id);
		try {
			response.getWriter().write(jsonConverter.JSON_OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
