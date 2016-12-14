package com.jirafe.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jirafe.services.JsonConverter;
import com.jirafe.services.TaskClockingService;

@Controller
@RequestMapping("/clocking")
public class TaskClockingController {
	
	@Autowired
	private TaskClockingService taskClockingService;
	
	@Autowired
	private JsonConverter jsonConverter;

	@RequestMapping(value="", method=RequestMethod.GET)
	public void findAllClocking(HttpServletResponse response) {
		try {
			response.getWriter().write(jsonConverter.toJson(taskClockingService.findAll()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
