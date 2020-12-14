package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.DatabaseConnection;

public class TransferDAO {

	public TransferDAO() {
	}

	public void updateAnotherAccount(int accountNumber, double balance) {
		DatabaseConnection DbConnection = new DatabaseConnection();
		Connection newConnection = DbConnection.getDbConnection();
		try {

			String sql = "update account set account_balance = ? where account_number=? returning account_number;";
			PreparedStatement depositStatement = newConnection.prepareStatement(sql);
			depositStatement.setDouble(1, balance);
			depositStatement.setInt(2, accountNumber);
			ResultSet result = depositStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}