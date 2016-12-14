package com.jirafe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jirafe.entities.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	
	List<Task> findByProjectId(long id);

}
