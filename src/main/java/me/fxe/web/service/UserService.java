package me.fxe.web.service;

import java.util.List;

import me.fxe.User;

public interface UserService {
	public List<User> getUsers();
	
	public User getUser(long id);
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(long id);
}
