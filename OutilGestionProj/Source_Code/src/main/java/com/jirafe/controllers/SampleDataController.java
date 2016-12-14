package com.jirafe.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jirafe.services.JsonConverter;
import com.jirafe.services.SampleDataService;

@Controller
public class SampleDataController {
	
	@Autowired
	private SampleDataService sampleDataService;

	@RequestMapping("/data")
	public void createData(HttpServletResponse resp) {
		sampleDataService.createData();
		try {
			resp.getWriter().write(JsonConverter.JSON_OK);
		} catch (Exception e) {
			
		}
	}
	
}
