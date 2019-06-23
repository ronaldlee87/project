package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionUtil {

	private static Connection connectionInstance = null;
	private static final Logger log = LogManager.getLogger(ConnectionUtil.class);

	private ConnectionUtil() {

	}

	public static Connection getConnection() {
		if (ConnectionUtil.connectionInstance != null) {
			return ConnectionUtil.connectionInstance;
		}

		InputStream in = null;

		try {
			// load information from properties file
			Properties props = new Properties();
			in = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");
			props.load(in);

			// get the connection object
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = null;

			String endpoint = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			con = DriverManager.getConnection(endpoint, username, password);
			connectionInstance = con;
			return connectionInstance;
		} catch (Exception e) {
			log.error("Unable to get connection to database");
		} finally {
			try {
				in.close();
			} catch (IOException e) {

			}
		}

		return null;
	}
}