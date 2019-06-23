package dao;

import java.util.List;

import project_0.Customer;

//import project_0.SuperUser;

public interface AccountDao {
	
//	Customer
	
	List<Customer> getAllCustomer() throws Exception;
	void insertCustomer(Customer c) throws Exception;

	
//	SuperUser	
	
//	List<SuperUser> getAllSuperUser() throws Exception;
//	void insertSuperUser(SuperUser s) throws Exception;

}
