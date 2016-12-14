package com.jirafe.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jirafe.entities.Project;
import com.jirafe.entities.Task;
import com.jirafe.entities.Task.Priority;
import com.jirafe.entities.Task.Status;
import com.jirafe.entities.User;

@Service
public class SampleDataServiceImpl implements SampleDataService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskServiceImpl taskService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskClockingService taskClockingService;
	
	@Override
	public void createData() {
		User u1 = new User("Lemaire", "Pauline", "lemaire.pauline@gmail.com");
		User u2 = new User("Delpech", "Clément", "clement.delpech@gmail.com");
		User u3 = new User("Ruffin", "Clément", "clement.ru@gmail.com");
		User u4 = new User("Latour", "Axel", "latour.axel@gmail.com");
		
		Project p1 = new Project(new Date(), new Date(), "Projet X", "La fête", null);
		Project p2 = new Project(new Date(), new Date(), "Projet 2", "Raspberry", null);
		
		Task t1 = new Task("Acheter les boissons", "au simply market", Status.TODO, Priority.HIGH, p1);
		Task t2 = new Task("Acheter les gateaux", "au simply market", Status.TODO, Priority.MEDIUM, p1);
		Task t3 = new Task("Configurer le rasp", "au simply market", Status.TODO, Priority.HIGH, p2);
		Task t4 = new Task("Taske", "au simply market", Status.TODO, Priority.HIGH, p2);
		Task t5 = new Task("Taskete", "au simply market", Status.TODO, Priority.HIGH, p2);
		
		userService.createUser(u1);
		userService.createUser(u2);
		userService.createUser(u3);
		userService.createUser(u4);
		
		userService.updateToken("LATOUR", "latour.axel@gmail.com");
		userService.updateToken("LEMAIRE", "lemaire.pauline@gmail.com");
		
		projectService.createProject(p1, "LATOUR");
		projectService.createProject(p2, "LEMAIRE");
		
		taskService.createTask(t1);
		taskService.createTask(t2);
		taskService.createTask(t3);
		taskService.createTask(t4);
		taskService.createTask(t5);
		
	}

}
