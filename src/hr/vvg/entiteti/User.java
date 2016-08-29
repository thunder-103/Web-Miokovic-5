package hr.vvg.entiteti;

public class User {
	
	private Integer userId;
	private String userName;
	private String userFirstName;
	private String userLastName;
	
	
	public User(Integer userId, String userName, String userFirstName, String userLastName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}
	
	public User() {
		
	}
	
    // overridden equals method
    public boolean equals(Object obj) {
    if (!(obj instanceof User)) {
    return false;
    }
    User user = (User) obj;

    return (this.userId == user.userId);

    }


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

}
