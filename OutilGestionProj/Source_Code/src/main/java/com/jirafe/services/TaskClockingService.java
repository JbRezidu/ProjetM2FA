package com.jirafe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jirafe.entities.TaskClocking;
import com.jirafe.repositories.TaskClockingRepository;

@Service
public class TaskClockingService {
	
	@Autowired
	private TaskClockingRepository taskClockingRepository;
	
	public List<TaskClocking> findAll() {
		List<TaskClocking> ret = new ArrayList<>();
		for(TaskClocking t : taskClockingRepository.findAll()) {
			ret.add(t);
		}
		return ret;
	}
	
}
