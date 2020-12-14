package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.models.CurrentUser;
import com.revature.util.DatabaseConnection;

public class AccountDAO {
	private int currentUserId;

	public AccountDAO() {
		this.currentUserId = CurrentUser.getUserId();
	}

	public Account getUserAccount() {
		DatabaseConnection DbConnection = new DatabaseConnection();
		Connection newConnection = DbConnection.getDbConnection();
		Account currentAccount = new Account();

		try {

			String sql = "select * from account where user_id=?;";
			PreparedStatement getAccountStatement = newConnection.prepareStatement(sql);
			getAccountStatement.setInt(1, this.currentUserId);
			ResultSet result = getAccountStatement.executeQuery();
			if (result.next()) {
				currentAccount.setAccountBalance(result.getDouble("account_balance"));
				currentAccount.setAccountNumber(result.getInt("account_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentAccount;

	}

	public void accountUpdate(double balance) {
		DatabaseConnection DbConnection = new DatabaseConnection();
		Connection newConnection = DbConnection.getDbConnection();
		try {

			String sql = "update account set account_balance = ? where user_id=? returning account_number;";
			PreparedStatement depositStatement = newConnection.prepareStatement(sql);
			depositStatement.setDouble(1, balance);
			depositStatement.setInt(2, this.currentUserId);
			ResultSet result = depositStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
