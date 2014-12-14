package me.fxe.dao;

import java.util.List;

import me.fxe.User;

public interface UserDao {
	public List<User> getUsers();
	
	public User getUser(long id);
	
	public User saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
}
