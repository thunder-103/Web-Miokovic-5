package hr.vvg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.naming.NamingException;

import hr.vvg.entiteti.Task;
import hr.vvg.task.service.TaskServiceDatabase;


@ManagedBean 
@ViewScoped
public class DisplayTaskController {
	
	private List<Task> taskList;
	
	@PostConstruct
	private void init() {
		
		try {
			taskList = TaskServiceDatabase.fetchTaskList();
		} catch (SQLException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public String backButton() {
		
		return "/jsf/createTask.xhtml";
	}*/

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	

}
