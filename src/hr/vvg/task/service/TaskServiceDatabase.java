package hr.vvg.task.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import hr.vvg.database.DatabaseUtils;
import hr.vvg.entiteti.Project;
import hr.vvg.entiteti.Task;
import hr.vvg.entiteti.User;

public class TaskServiceDatabase {	
	
	private static List<User> userList;

	private static List<Project> projectList;
	
	private static List<Integer> estimatedTimeList;
	
	private static List<Task> taskList;
		 
	public static List<User> fetchUserList() throws SQLException, IOException, NamingException{
		
		userList = DatabaseUtils.fetchDatabaseUserList();
		
		return userList;
	}

	public static List<Project> fetchProjectList() throws SQLException, IOException, NamingException{
		
		projectList = DatabaseUtils.fetchDatabaseProjectList();
		
		return projectList;
	}
	
	public static List<Integer> fetchEstimatedTime() {
	
	estimatedTimeList = new ArrayList<Integer>();
	
	for(int i=1; i<9; i++){
	
		estimatedTimeList.add(i);
	
	}
	
	return estimatedTimeList;
	
	}
	
	public static List<Task> fetchTaskList() throws SQLException, IOException, NamingException{
		
		taskList = DatabaseUtils.fetchDatabaseTaskList();
		
		return taskList;
	}
	
	
	

}
