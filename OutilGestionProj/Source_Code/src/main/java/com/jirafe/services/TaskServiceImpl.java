package com.jirafe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jirafe.entities.Task;
import com.jirafe.entities.Task.Status;
import com.jirafe.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void createTask(Task task){
		taskRepository.save(task);
	}
	
	@Override
	public List<Task> getTasksByProject(long idProject){
		return taskRepository.findByProjectId(idProject);
	}
	
	@Override
	public Task getTask(long id){
		return taskRepository.findOne(id);
	}
	
	public void deleteTask(long id){
		taskRepository.delete(id);
	}
	
	public void updateTaskStatus(long id, String status){
		Task task = taskRepository.findOne(id);
		task.setStatus(Status.valueOf(status));
		taskRepository.save(task);
	}
	
}
