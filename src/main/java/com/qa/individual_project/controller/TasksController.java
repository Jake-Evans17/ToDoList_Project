package com.qa.individual_project.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.individual_project.model.Task;
import com.qa.individual_project.repository.TasksRepository;

@RestController
@RequestMapping("api/v1/")
public class TasksController {
	
	@Autowired
	private TasksRepository tasksRepository;
	
	@RequestMapping(value = "tasks", method = RequestMethod.GET)
    public List<Task> list(){
        return tasksRepository.findAll();
    }

	@RequestMapping(value = "tasks", method = RequestMethod.POST)
    public Task create(@RequestBody Task task){
        LocalDate localDate = LocalDate.now();
        task.setDateSet(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate));
        return tasksRepository.saveAndFlush(task);
    }

	@RequestMapping(value = "tasks/{id}", method = RequestMethod.GET)
    public Task get(@PathVariable int id){
        return tasksRepository.findOne(id);
    }

	@RequestMapping(value = "tasks/{id}", method = RequestMethod.PUT)
    public Task update(@PathVariable int id, @RequestBody Task task){
        Task existingTask = tasksRepository.findOne(id);
        BeanUtils.copyProperties(task, existingTask);
        return tasksRepository.saveAndFlush(task);
    }

	@RequestMapping(value = "tasks/{id}", method = RequestMethod.DELETE)
    public Task delete(@PathVariable int id){
        Task existingTask = tasksRepository.findOne(id);
        tasksRepository.delete(existingTask);
        return existingTask;
    }
	
	@RequestMapping(value = "tasks//{complete}", method = RequestMethod.GET)
    public List<Task> findByComplete(@PathVariable boolean complete){
        return tasksRepository.findByComplete(complete);
    }
	
	@RequestMapping(value = "tasks/userId/{userId}", method = RequestMethod.GET)
    public List<Task> findByUserId(@PathVariable int userId){
        return tasksRepository.findByUserId(userId);
    }
	
	@RequestMapping(value = "tasks/userId/{userId}/{complete}", method = RequestMethod.GET)
    public List<Task> findByUserIdAndComplete(@PathVariable int userId, @PathVariable boolean complete){
        return tasksRepository.findByUserIdAndComplete(userId, complete);
    }
}