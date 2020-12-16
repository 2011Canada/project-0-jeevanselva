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

	public User createUser(User newUser) {
		Connection newConnection = DbConnection.getDbConnection();

		try {

			String sql = "insert into \"user\"(person_id, user_name,"
					+ " password, role) values (?,?,?,?) returning user_id;";
			PreparedStatement createUserStatement = newConnection.prepareStatement(sql);
			createUserStatement.setInt(1, newUser.getPersonId());
			createUserStatement.setString(2, newUser.getUserName());
			createUserStatement.setString(3, newUser.getPassword());
			createUserStatement.setString(4, newUser.getRole());

			ResultSet result = createUserStatement.executeQuery();
			if (result.next()) {
				newUser.setPersonId(result.getInt("user_Id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newUser;

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
