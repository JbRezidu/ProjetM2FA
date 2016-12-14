package com.jirafe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jirafe.entities.TaskClocking;

public interface TaskClockingRepository extends CrudRepository<TaskClocking, Long> {
	
}
