package hr.vvg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;
import hr.vvg.database.DatabaseUtils;
import hr.vvg.entiteti.Project;
import hr.vvg.entiteti.User;
import hr.vvg.task.service.TaskServiceDatabase;

@ManagedBean 
@SessionScoped
public class CreateTaskController {
	
	private List<User> userList;
	private List<Project> projectList;
	private List<Integer> estimatedTimeList;
	private User user;
	private Project project;
	private String taskDescription;
	private Integer estimatedTime;
	
	@PostConstruct
	private void init() {
		
		
		try {
			if(userList == null) {
				
				userList = new ArrayList<>();
				
			}
			userList = TaskServiceDatabase.fetchUserList();
		} catch (SQLException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			projectList = TaskServiceDatabase.fetchProjectList();
		} catch (SQLException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		estimatedTimeList = TaskServiceDatabase.fetchEstimatedTime();
		
	}
	
	
	public String saveTask() {
		
		try {
			DatabaseUtils.insertTaskIntoDatabase(project, user, taskDescription, estimatedTime);
		} catch (SQLException | NamingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/jsf/taskList.xhtml";
	}
	
	public String backButton() {
		
		this.user = null;
		this.project = null;
		this.taskDescription = null;
		this.estimatedTime = null;
		
		return "/jsf/createTask.xhtml";

	}
	

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<Integer> getEstimatedTimeList() {
		return estimatedTimeList;
	}

	public void setEstimatedTimeList(List<Integer> estimatedTimeList) {
		this.estimatedTimeList = estimatedTimeList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Integer getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(Integer estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	
	

}
