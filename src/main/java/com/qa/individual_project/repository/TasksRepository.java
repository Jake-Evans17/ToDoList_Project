package com.qa.individual_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.individual_project.model.Task;

public interface TasksRepository extends JpaRepository<Task, Integer> {
	List<Task> findByComplete(boolean complete);
	
	List<Task> findByUserId(int userId);
	
	List<Task> findByUserIdAndComplete(int userId, boolean complete);

}
