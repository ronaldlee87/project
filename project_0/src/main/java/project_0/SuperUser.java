package project_0;

public class SuperUser {
	
	private String name;
	private int ssn;
	private String user_id;
	private String password;
	private final int isAdmin = 1;
	private int isActivated;
//	String user_id, String password, String name, int isAdmin, int isActivated, int ssn, Account account
	public SuperUser(String user_id, String password, String name, int isAdmin, int isActivated, int ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.user_id = user_id;
		this.password = password;
		this.isActivated = isActivated;
	}

	public int getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(int isActivated) {
		this.isActivated = isActivated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSsn() {
		return ssn;
	}

//	public void setSsn(int ssn) {
//		this.ssn = ssn;
//	}

	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}

	@Override
	public String toString() {
		return "SuperUser [name=" + name + ", ssn=" + ssn + ", user_id=" + user_id + "]";
	}
	
}
