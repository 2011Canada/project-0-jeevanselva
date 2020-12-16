package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.launcher.BankAppLauncher;
import com.revature.util.DatabaseConnection;

public class TransferDAO {

	public TransferDAO() {
	}

	public double readAnotherAccount(int accountNumber) {
		DatabaseConnection DbConnection = new DatabaseConnection();
		Connection newConnection = DbConnection.getDbConnection();
		double balance = 0;
		try {

			String sql = "select account_balance from account where account_number=?;";
			PreparedStatement readStatement = newConnection.prepareStatement(sql);
			readStatement.setDouble(1, accountNumber);
			ResultSet result = readStatement.executeQuery();

			if (result.next()) {
				balance = result.getDouble("account_balance");
			}
		} catch (SQLException e) {

			BankAppLauncher.appLogger.error("Internal error occured in the database");
		}
		return balance;
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

			BankAppLauncher.appLogger.error("Internal error occured in the database");
		}
	}

}