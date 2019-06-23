package util;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.util.List;

import dao.AccountService;
import project_0.Customer;
//import project_0.SuperUser;

public class Application {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		System.out.println(con);		
		
		List<Customer> list;
		try {			
			list = AccountService.getAllCustomer();
		} catch (Exception e) {
			System.out.println("Opps.. (^_^)");
			return;
		}
		
		System.out.println(list);
		
		
		
		
		
	}
}
