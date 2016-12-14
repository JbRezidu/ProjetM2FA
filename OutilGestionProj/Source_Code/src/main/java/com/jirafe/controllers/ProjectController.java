package com.jirafe.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jirafe.services.JsonConverter;
import com.jirafe.services.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	JsonConverter jsonConverterService;

	@Autowired
	ProjectService projectService;

	@RequestMapping("/project/create")
	public void createProject(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "token") String token) {
		String chain = "";

		try {
			String line;

			while ((line = request.getReader().readLine()) != null)
				chain += line;

			projectService.createProject(jsonConverterService.projectFromJson(chain), token);
			response.getWriter().write(JsonConverter.JSON_OK);
		} catch (IOException e1) {
			try {
				response.getWriter().write(JsonConverter.JSON_ERROR);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("/project/all")
	public void getAllProject(HttpServletResponse response) {
		try {
			response.getWriter().write(jsonConverterService.toJson(projectService.getAllProjects()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/project/id")
	public void getProjectById(HttpServletResponse response, @RequestParam(name = "id") long id) {
		try {
			response.getWriter().write(jsonConverterService.toJson(projectService.getProject(id)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/project/addDev")
	public void addDev(
			@RequestParam(name="mail") String mail,
			@RequestParam(name="projectId") Long projectId,
			HttpServletResponse response) {
		
		if(projectService.addDeveloper(projectId, mail)) {
			try {
				response.getWriter().write(JsonConverter.JSON_OK);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().write(JsonConverter.JSON_ERROR);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
