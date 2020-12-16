package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.launcher.BankAppLauncher;
import com.revature.models.Person;
import com.revature.util.DatabaseConnection;

public class PersonDAO {
	DatabaseConnection DbConnection = new DatabaseConnection();

	public PersonDAO() {
		super();
	}

	public Person createPerson(Person person) {
		Connection newConnection = DbConnection.getDbConnection();

		try {

			String sql = "insert into person (first_name, last_name, age, phone_number, email_address)"
					+ "  values(?,?,?,?,?) returning person_id;";
			PreparedStatement createPersonStatement = newConnection.prepareStatement(sql);
			createPersonStatement.setString(1, person.getFirstName());
			createPersonStatement.setString(2, person.getLastName());
			createPersonStatement.setInt(3, person.getAge());
			createPersonStatement.setString(4, person.getPhoneNumber());
			createPersonStatement.setString(5, person.getEmailAddress());

			ResultSet result = createPersonStatement.executeQuery();
			if (result.next()) {
				person.setPersonId(result.getInt("person_Id"));
			}
		} catch (SQLException e) {
			BankAppLauncher.appLogger.catching(e);
			BankAppLauncher.appLogger.error("Internal error occured in the database");
		}

		return person;
	}

}
