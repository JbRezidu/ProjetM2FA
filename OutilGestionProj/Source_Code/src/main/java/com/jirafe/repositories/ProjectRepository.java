package com.jirafe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jirafe.entities.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>
{
	
}
