package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.models.CurrentUser;
import com.revature.models.ListOfAccounts;
import com.revature.util.DatabaseConnection;

public class AccountDAO {
	private int currentAccountNumber;
	private int currentUserId;

	public AccountDAO() {
		this.currentAccountNumber = CurrentUser.getCurrentAccount();
		this.currentUserId = CurrentUser.getUserId();
	}

	public Account createAccount(Account account) {
		DatabaseConnection DbConnection = new DatabaseConnection();
		Connection newConnection = DbConnection.getDbConnection();

		try {

			String sql = "insert into account(account_number, type, account_balance, user_id) "
					+ "values (?,?,?,?) returning account_number;";
			PreparedStatement createPersonStatement = newConnection.prepareStatement(sql);
			createPersonStatement.setInt(1, account.getAccountNumber());
			createPersonStatement.setString(2, account.getType());
			createPersonStatement.setDouble(3, account.getAccountBalance());
			createPersonStatement.setInt(4, account.getUserId());
			createPersonStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	public Account getUserAccount() {
		DatabaseConnection DbConnection = new DatabaseConnection();
		Connection newConnection = DbConnection.getDbConnection();
		Account currentAccount = new Account();

		try {

			String sql = "select * from account where account_number=?;";
			PreparedStatement getAccountStatement = newConnection.prepareStatement(sql);
			getAccountStatement.setInt(1, this.currentAccountNumber);
			ResultSet result = getAccountStatement.executeQuery();
			if (result.next()) {
				currentAccount.setAccountBalance(result.getDouble("account_balance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentAccount;

	}

	public ListOfAccounts checkMultipleAccounts() {
		DatabaseConnection DbConnection = new DatabaseConnection();
		Connection newConnection = DbConnection.getDbConnection();
		ListOfAccounts listOfAccounts = new ListOfAccounts();

		try {

			String sql = "select * from account where user_id = ?;";
			PreparedStatement getAccountStatement = newConnection.prepareStatement(sql);
			getAccountStatement.setInt(1, this.currentUserId);
			ResultSet result = getAccountStatement.executeQuery();
			while (result.next()) {
				Account currentAccount = new Account();
				currentAccount.setAccountBalance(result.getDouble("account_balance"));
				currentAccount.setAccountNumber(result.getInt("account_number"));
				currentAccount.setUserId(result.getInt("user_id"));
				currentAccount.setType(result.getString("type"));
				listOfAccounts.addAccount(currentAccount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfAccounts;
	}

	public ListOfAccounts getAllAccounts() {
		DatabaseConnection DbConnection = new DatabaseConnection();
		Connection newConnection = DbConnection.getDbConnection();
		ListOfAccounts listOfAccounts = new ListOfAccounts();

		try {

			String sql = "select * from account;";
			PreparedStatement getAccountStatement = newConnection.prepareStatement(sql);
			ResultSet result = getAccountStatement.executeQuery();
			while (result.next()) {
				Account currentAccount = new Account();
				currentAccount.setAccountBalance(result.getDouble("account_balance"));
				currentAccount.setAccountNumber(result.getInt("account_number"));
				currentAccount.setUserId(result.getInt("user_id"));
				currentAccount.setType(result.getString("type"));
				listOfAccounts.addAccount(currentAccount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfAccounts;

	}

	public void accountUpdate(double balance) {
		DatabaseConnection DbConnection = new DatabaseConnection();
		Connection newConnection = DbConnection.getDbConnection();
		try {

			String sql = "update account set account_balance = ? where account_number=? returning user_id;";
			PreparedStatement depositStatement = newConnection.prepareStatement(sql);
			depositStatement.setDouble(1, balance);
			depositStatement.setInt(2, this.currentAccountNumber);
			ResultSet result = depositStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
