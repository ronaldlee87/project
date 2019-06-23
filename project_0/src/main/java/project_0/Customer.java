package project_0;

public class Customer {
	private String name;
	private int ssn;
	private Account account;
	private String user_id;
	private String password;
	private final int isAdmin = 0;
	private int isActivated;
	
	// Custormer's Information
	public Customer(String user_id, String password, String name, int isAdmin, int isActivated, int ssn, Account account) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.user_id = user_id;
		this.password = password;
		this.isActivated = isActivated;
		this.account = account;
	}


	public Customer(String user_id, String password, String name, int isAdmin, int isActivated, int ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.user_id = user_id;
		this.password = password;
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

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	//Account number have No setter since we shouldn't change it
	public Account getAccount() {
		return account;
	}
//	public void setAccount(Account account) {
//		this.account = account;
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
	
//	public void setIsAdmin(int isAdmin) {
//		this.isAdmin = isAdmin;
//	}

	public int getIsActivated() {
		return isActivated;
	}
	
	public void setIsActivated(int isActivated) {
		this.isActivated = isActivated;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", account=" + account + ", user_id=" + user_id
				+ ", password=" + password + ", isAdmin=" + isAdmin + ", isActivated=" + isActivated + "]";
	}



}
