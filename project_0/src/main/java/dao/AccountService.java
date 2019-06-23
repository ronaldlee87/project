package dao;

//import java.sql.SQLException;
import java.util.List;

import project_0.Customer;
//import project_0.SuperUser;

public class AccountService {
	private static final AccountDao dao = new AccountOracle();
	
//	Customer
	
	public static List<Customer> getAllCustomer() throws Exception {
		return dao.getAllCustomer();
	}
	
	public static void insertCustomer(Customer c) throws Exception {
		dao.insertCustomer(c);
	}
	
//	SuperUser
	
//	public static List<Customer> getAllSuperUser() throws Exception {
//		return dao.getAllSuperUser();
//	}
//	
//	public static void insertSuperUser(SuperUser s) throws Exception {
//		dao.insertSuperUser(s);
//	}
	
	
}
