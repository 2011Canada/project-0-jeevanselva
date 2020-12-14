package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.util.DatabaseConnection;

public class UserDAO {
	DatabaseConnection DbConnection = new DatabaseConnection();

	public UserDAO() {
		super();
	}

	public void createUser() {
	}

	public void deleteUser() {
	}

	public User readUser(String user, String password) {
		Connection newConnection = DbConnection.getDbConnection();
		User currentUser = new User();

		try {

			String sql = "select * from \"user\" where user_name=? and password =?;";
			PreparedStatement readUserStatement = newConnection.prepareStatement(sql);
			readUserStatement.setString(1, user);
			readUserStatement.setString(2, password);

			ResultSet result = readUserStatement.executeQuery();
			if (result.next()) {
				currentUser.setUserId(result.getInt("user_Id"));
				currentUser.setRole(result.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentUser;
	}

	public void updateUser() {
	}

}
