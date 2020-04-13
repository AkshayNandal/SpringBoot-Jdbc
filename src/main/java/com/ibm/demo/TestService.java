package com.ibm.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	UserDao dao;

	Integer getCountOfUsers() {
		return dao.getCountOfUsers();
	}
	
	int createAccount(Account account) {
		return dao.createAccount(account);
	}
	
	String getUserName(String id) {
		return dao.getUserName(id);
	}
	
	int updateAccountBalance(String id, int amount) {
		return dao.updateAccount(id, amount);
	}
	
	int deleteAccount(String id) {
		return dao.deleteAccount(id);
	}
	
	List<Account> getAllUsers(){
		return dao.getAllUsers();
	}
	
}
