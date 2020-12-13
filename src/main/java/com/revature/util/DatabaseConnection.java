package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private Connection dbConnection;

	public DatabaseConnection() {
		try {
			String url = System.getenv("DB_URL");
			String user = System.getenv("DB_USER");
			String password = System.getenv("DB_PASSWORD");
			this.dbConnection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getDbConnection() {
		return dbConnection;
	}

}
