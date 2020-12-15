package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Account;
import com.revature.models.ChequingAccount;
import com.revature.repositories.AccountDAO;

public class AccountServiceTest {
	AccountDAO dao;
	Account account;
	AccountService service;

	@BeforeEach
	public void setupTestConditions() {
		this.dao = mock(AccountDAO.class);
		this.account = new ChequingAccount();
		this.account.setAccountBalance(1000);
		this.service = new AccountService();

	}

	@Test
	public void testAccountBalanceService() {
		double expectedValue = 1000;
		when(dao.getUserAccount()).thenReturn(this.account);
		assertEquals(expectedValue, this.service.accountBalanceService());
		verify(service).accountBalanceService();
	}

}
