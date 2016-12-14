package com.jirafe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jirafe.entities.Project;
import com.jirafe.entities.Task;
import com.jirafe.entities.TaskClocking;
import com.jirafe.entities.User;

@Service
public class JsonConverter {
	
	private Gson gson;
	
	public static final String JSON_ERROR = "{\"ok\":false}";
	public static final String JSON_OK = "{\"ok\":true}";
	
	public JsonConverter() {
		gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	}
	
	public String toJson(Object object) {
		if(object == null) {
			return JSON_ERROR;
		}
		String content = gson.toJson(object);
		return "{\"ok\":true, \"content\":" + content + "}";
	}
	
	public String toJson(Object [] object) {
		if(object == null) {
			return JSON_ERROR;
		}
		String content = gson.toJson(object);
		return "{\"ok\":true, \"content\":" + content + "}";
	}
	
	public String toJson(List<?> object) {
		if(object == null) {
			return JSON_ERROR;
		}
		String content = gson.toJson(object);
		return "{\"ok\":true, \"content\":" + content + "}";
	}
	
	public User userFromJson(String json) {
		return gson.fromJson(json, User.class);
	}
	
	public Project projectFromJson(String json) {
		return gson.fromJson(json, Project.class);
	}
	
	public Task taskFromJson(String json) {
		return gson.fromJson(json, Task.class);
	}
	
	public TaskClocking taskClockingFromJson(String json) {
		return gson.fromJson(json, TaskClocking.class);
	}

	public JsonElement fromJson(String json) {
		JsonParser parser = new JsonParser();
		return parser.parse(json);
	}
	
}
