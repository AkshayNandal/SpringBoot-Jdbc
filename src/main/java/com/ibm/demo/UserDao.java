package com.ibm.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements AccountDao{

	@Autowired
	JdbcTemplate template;
	
	Integer getCountOfUsers() {
		return template.queryForObject("Select count(AccountID) from Account", Integer.class);
	}
	
	String getUserName(String id) {
		return template.queryForObject("Select Account_Name from Account where AccountID=?",new Object[] {id}, String.class);
	}
	
	@Override
	public int createAccount(Account account) {
		return template.update("Insert into Account values(?,?,?,?)",
				new Object[] {account.getAccountID(),account.getAccount_Name(),account.getAccount_Balance(),account.getPin()});
	}

	@Override
	public int updateAccount(String id, int amount) {
		String sql="UPDATE Account Set Account_Balance=? where AccountID=?";
		return template.update(sql, new Object[] {amount,id});
	}

	@Override
	public int deleteAccount(String id) {
		String sql="Delete FROM Account where AccountID=?";
		return template.update(sql, new Object[] {id});
	}

	@Override
	public List<Account> getAllUsers() {
    List<Account> list = template.query("Select * from Account", new BeanPropertyRowMapper<Account>(){
			@Override
			public Account mapRow(ResultSet rs, int rollNum) throws SQLException{
				Account account = new Account();
				account.setAccountID(rs.getString("AccountID"));
				account.setAccount_Name(rs.getString("Account_Name"));
				account.setAccount_Balance(rs.getDouble("Account_Balance"));
				account.setPin(rs.getString("Pin"));
				return account;
			}
 		});
		return list;
	}
}
