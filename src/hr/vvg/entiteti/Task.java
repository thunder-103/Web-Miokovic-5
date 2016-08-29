package hr.vvg.entiteti;

public class Task {
	
	private Integer taskId;
	private User user;
	private Project project;
	private String taskDescription;
	private Integer estimatedTime;
	
	public Task(Integer taskId, User user, Project project, String taskDescription, Integer estimatedTime) {
		super();
		this.taskId = taskId;
		this.user = user;
		this.project = project;
		this.taskDescription = taskDescription;
		this.estimatedTime = estimatedTime;
	}

	public Task() {

	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
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
