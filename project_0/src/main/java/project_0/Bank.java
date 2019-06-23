package project_0;

import java.util.ArrayList;

public class Bank {
	
	// Create ArrayList to get Information from Customer and SuperUswer
	ArrayList<Customer> customerInfo = new ArrayList<Customer>();
	ArrayList<SuperUser> superuserInfo = new ArrayList<SuperUser>();
	
	//Customer
	public void addCustomer(Customer customer) {
		customerInfo.add(customer);
	}
	
	public Customer getCustomer(int account) {
		return customerInfo.get(account);
	}
	
	public ArrayList<Customer> getCustomerInfo() {
		return customerInfo;
	}
	
	//SuperUser
	public void addSuperUser(SuperUser superuser) {
		superuserInfo.add(superuser);
	}
	
	public SuperUser getSuperUser (int account) {
		return superuserInfo.get(account);
	}
	
	public ArrayList<SuperUser> getSuperUserInfo() {
		return superuserInfo;
	}
	
}
