package com.dao;

import java.util.List;

import com.pojos.User;

public interface ILoginDao {
	
	public List<User> getUserDetails(int id , String password);
	
	public List<User> getAllUsers();

}
