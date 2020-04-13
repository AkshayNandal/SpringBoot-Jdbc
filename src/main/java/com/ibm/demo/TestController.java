package com.ibm.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	TestService service;
	
	@RequestMapping("/count")
	Integer getCountOfUsers() {
		return service.getCountOfUsers();
	}
	
	@RequestMapping("/name/{id}")
	String getUserName(@PathVariable String id) {
		return service.getUserName(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/name/create")
		int createAccount(@RequestBody Account account) {
			return service.createAccount(account);
		}
	
	@RequestMapping(method=RequestMethod.PUT, value="/name/update/{id}/{amount}")
	int updateAccountBalance(@PathVariable String id, @PathVariable int amount) {
		//System.out.println("Account Balance Updated");
		return service.updateAccountBalance(id, amount);
		}
	
		@RequestMapping("/name/delete/{id}")
		int deleteAccount(@PathVariable String id) {
			System.out.println("Account Deleted");
			return service.deleteAccount(id);
		}
		
		@RequestMapping(method=RequestMethod.GET, value="/name/all")
		List<Account> getAllUser(){
			return service.getAllUsers();
		}
}