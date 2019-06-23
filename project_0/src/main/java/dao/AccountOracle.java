package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import project_0.Customer;
//import project_0.SuperUser;
import util.ConnectionUtil;

public class AccountOracle implements AccountDao {

	private static final Logger log = LogManager.getLogger(AccountOracle.class);

	public List<Customer> getAllCustomer() throws Exception {
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}

		List<Customer> list;

		try {
			String sql = "SELECT * FROM BANK_USER_INFO";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			list = new ArrayList<Customer>();

			while (rs.next()) {
				list.add(new Customer(rs.getString("user_id"), rs.getString("password"), 
						rs.getString("name"), rs.getInt("isAdmin"), rs.getInt("isActivated"), 
						rs.getInt("ssn")));
			}
		} catch (SQLException e) {
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}

		return list;

	}

	public void insertCustomer(Customer c) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}
System.out.println(c);
//		List<Customer> list;
		
		try {
			String sql = "INSERT INTO BANK_USER_INFO (user_id, password, name, isAdmin, isActivated, ssn, accountNumber, balance) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, c.getUser_id());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getName());
			ps.setInt(4, c.getIsAdmin());
			ps.setInt(5, c.getIsActivated());
			ps.setInt(6, c.getSsn());
			ps.setInt(7, c.getAccount().getAccountNumber());
			ps.setInt(8, c.getAccount().getBalance());
			ps.executeUpdate();
//			list = new ArrayList<Customer>();

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
	}
	
	
	
}	
	
		
//////////////////////////////////////////////////////////////////////
//		SuperUser													//
//////////////////////////////////////////////////////////////////////		
		
//		public List<SuperUser> getAllSuperUser() throws Exception {
//			Connection con = ConnectionUtil.getConnection();
//
//			if (con == null) {
//				log.error("Connection was null");
//				throw new Exception("Unable to connect to database");
//			}
//
//			List<SuperUser> list;
//
//			try {
//				String sql = "SELECT * FROM BANK_USER_INFO";
//				PreparedStatement ps = con.prepareStatement(sql);
//				ResultSet rs = ps.executeQuery();
//
//				list = new ArrayList<SuperUser>();
//
//				while (rs.next()) {
//					list.add(new SuperUser(rs.getString("user_id"), rs.getString("password"), 
//							rs.getString("name"), rs.getInt("isAdmin"), rs.getInt("isActivated"), 
//							rs.getInt("ssn")));
//				}
//			} catch (SQLException e) {
//				log.error("Unable to execute sql query", e);
//				throw new Exception("Unable to connect to database");
//			}
//
//			return list;
//
//		}
//
//		public void insertSuperUser(SuperUser s) throws Exception {
//			Connection con = ConnectionUtil.getConnection();
//			if (con == null) {
//				log.error("Connection was null");
//				throw new Exception("Unable to connect to database");
//			}
//	System.out.println(s);
//			List<SuperUser> list;
//			
//			try {
//				String sql = "INSERT INTO BANK_USER_INFO (user_id, password, name, isAdmin, isActivated, ssn, accountNumber, balance) VALUES (?,?,?,?,?,?,?,?)";
//				PreparedStatement ps = con.prepareStatement(sql);
//
//				ps.setString(1, s.getUser_id());
//				ps.setString(2, s.getPassword());
//				ps.setString(3, s.getName());
//				ps.setInt(4, s.getIsAdmin());
//				ps.setInt(5, s.getIsActivated());
//				ps.setInt(6, s.getSsn());
//				ps.setInt(7, s.getAccount().getAccountNumber());
//				ps.setInt(8, s.getAccount().getBalance());
//				ps.executeUpdate();
//				list = new ArrayList<SuperUser>();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//				log.error("Unable to execute sql query", e);
//				throw new Exception("Unable to connect to database");
//			}
//		}

		
