package hr.vvg.entiteti;

public class Project {
	
	private Integer projectId;
	private String projectName;
	private String projectCompany;
	
	public Project(Integer projectId, String projectName, String projectCompany) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectCompany = projectCompany;
	}
	
	public Project() {
		
		
	}
	
    // overridden equals method
    public boolean equals(Object obj) {
    if (!(obj instanceof Project)) {
    return false;
    }
    Project project = (Project) obj;

    return (this.projectId == project.projectId);

    }

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCompany() {
		return projectCompany;
	}

	public void setProjectCompany(String projectCompany) {
		this.projectCompany = projectCompany;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
