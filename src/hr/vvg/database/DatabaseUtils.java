package hr.vvg.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import hr.vvg.configuration.Configuration;
import hr.vvg.entiteti.Project;
import hr.vvg.entiteti.Task;
import hr.vvg.entiteti.User;
import hr.vvg.task.service.TaskServiceDatabase;


public class DatabaseUtils {
	
	private static Connection connectToDatabase() throws SQLException, IOException, NamingException {
		
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup(Configuration.LOOKUP_CONTEXT_NAME);
		DataSource dataSource = (DataSource) envCtx.lookup(Configuration.DATASOURCE_NAME);

		Connection conn = dataSource.getConnection();
		
		return conn;
	}

	private static void closeConnectionToDatabase(final Connection p_connection) throws SQLException {
		
		p_connection.close();
		
	}
	
	public static List<User> fetchDatabaseUserList() throws SQLException, IOException, NamingException {
		
		List<User> userList = new ArrayList<User>();
		
		Connection conn = connectToDatabase();
		
		PreparedStatement stmt = conn.prepareStatement("SELECT ID, USERNAME, FIRSTNAME, LASTNAME FROM TASK.APP_USER");
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()){
			
			User user = new User(); 
			
			user.setUserId(rs.getInt("ID"));
			
			user.setUserName(rs.getString("USERNAME"));
			
			user.setUserFirstName(rs.getString("FIRSTNAME"));
			
			user.setUserLastName(rs.getString("LASTNAME"));
			
			userList.add(user);
		}

		
		closeConnectionToDatabase(conn);
		
		return userList;
		
	}
	
	public static List<Project> fetchDatabaseProjectList() throws SQLException, IOException, NamingException {
		
		List<Project> projectList = new ArrayList<Project>();
		
		Connection conn = connectToDatabase();
		
		PreparedStatement stmt = conn.prepareStatement("SELECT ID, NAME, COMPANYNAME FROM TASK.PROJECT");
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()){
			
			Project project = new Project(); 
			
			project.setProjectId(rs.getInt("ID"));
			
			project.setProjectName(rs.getString("NAME"));
			
			project.setProjectCompany(rs.getString("COMPANYNAME"));
			
			projectList.add(project);
		}

		
		closeConnectionToDatabase(conn);
		
		return projectList;
		
	}
	
	public static void insertTaskIntoDatabase(final Project project, final User user,
			final String taskDescription, Integer estimatedTime) throws SQLException, NamingException, IOException {
		
		Connection conn = connectToDatabase();
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO TASK.PROJECT_TASK (PROJECTID, USERID, "
				+ "DESCRIPTION, ESTIMATEDDURATIONHOURS) VALUES (?, ?, ?, ?)");

		stmt.setInt(1, project.getProjectId());
		stmt.setInt(2, user.getUserId());
		stmt.setString(3, taskDescription);
		stmt.setInt(4, estimatedTime);
		
		stmt.executeUpdate();
		
		closeConnectionToDatabase(conn);
	}
	
	public static List<Task> fetchDatabaseTaskList() throws SQLException, IOException, NamingException {
		
		List<Task> tasktList = new ArrayList<Task>();
		
		Connection conn = connectToDatabase();
		
		PreparedStatement stmt = conn.prepareStatement("SELECT ID, PROJECTID, USERID, DESCRIPTION, "
				+ "ESTIMATEDDURATIONHOURS FROM TASK.PROJECT_TASK");
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()){
			
			Task task = new Task(); 
		
			task.setProject(findProjectById(rs.getInt("PROJECTID")));
			
			task.setUser(findUserById(rs.getInt("USERID")));
			
			task.setTaskDescription(rs.getString("DESCRIPTION"));
			
			task.setEstimatedTime(rs.getInt("ESTIMATEDDURATIONHOURS"));
			
			tasktList.add(task);
		}

		
		closeConnectionToDatabase(conn);
		
		return tasktList;
		
	}
	
	private static Project findProjectById(Integer id) {
		
		Project project = null;
		
		try {
			for(Project temp : TaskServiceDatabase.fetchProjectList()) {
				if(temp.getProjectId() == id) {
					
					project = temp;
					break;
				}
				
			}
		} catch (SQLException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
	}
	
	private static User findUserById(Integer id) {
		
		User user = null;
		
		try {
			for(User temp : TaskServiceDatabase.fetchUserList()) {
				if(temp.getUserId() == id) {
					
					user = temp;
					break;
				}
				
			}
		} catch (SQLException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


}
