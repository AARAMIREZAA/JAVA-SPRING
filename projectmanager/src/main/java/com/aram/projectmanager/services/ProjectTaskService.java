package com.aram.projectmanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aram.projectmanager.models.Task;
import com.aram.projectmanager.repositories.TaskRepo;

@Service
public class ProjectTaskService {
	private final TaskRepo taskRepo;
	
	public ProjectTaskService(TaskRepo taskRepo) {
		this.taskRepo = taskRepo;
	}
	
	public List<Task> allTasks(){
		return taskRepo.findAll();
	}
	
	public List<Task> projectTasks(Long projectId){
		return taskRepo.findByProjectIdIs(projectId);
	}
	
	public Task addTask(Task task) {
		return taskRepo.save(task);
	}
	
	public void deleteTask(Task task) {
		taskRepo.delete(task);
	}
}