package com.jirafe.services;

import java.util.List;

import com.jirafe.entities.Task;

public interface TaskService {

	void createTask(Task task);
	
	List<Task> getTasksByProject(long idProject);
	
	Task getTask(long id);
	
}
