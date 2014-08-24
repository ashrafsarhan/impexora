/**
 * 
 */
package com.impexora.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.impexora.settings.ApplicationSettings;

/**
 * @author ashraf_sarhan
 * 
 */
public class DbConnectionManager {
	
	private static Logger logger = Logger.getLogger(DbConnectionManager.class.getSimpleName());
	
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = ApplicationSettings.getProperty("db.driverClass");
	private static final String DB_URL = ApplicationSettings.getProperty("db.connectionURL");

	// Database credentials
	private static final String USER = ApplicationSettings.getProperty("db.username");
	private static final String PASS = ApplicationSettings.getProperty("db.password");
	
    private static Connection conn = null;

	public DbConnectionManager() {
		
		if (conn == null) {
			try {
				// STEP 1: Register JDBC driver
				Class.forName(JDBC_DRIVER);
				// STEP 2: Open a connection
				logger.debug("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER,
						PASS);

			} catch (ClassNotFoundException e) {
				logger.error("Error in database connection");
				e.printStackTrace();
			} catch (SQLException e) {
				logger.error("Error in database SQL");
				e.printStackTrace();
			}
		}
	}

	public Connection getConn() {
		return conn;
	}

}
