package com.ibm.demo;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.ibm.demo.*;

public interface AccountDao {
	public int createAccount(Account account);
	public int updateAccount(String id, int amount);
	public int deleteAccount(String id);
	public List<Account> getAllUsers();
	
}
