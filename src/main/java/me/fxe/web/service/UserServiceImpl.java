package me.fxe.web.service;

import java.util.List;

import me.fxe.User;
import me.fxe.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public User getUser(long id) {
		return userDao.getUser(id);
	}
	
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
		return;
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		return;
	}

	@Override
	public void deleteUser(long id) {
		User user = userDao.getUser(id);
		if (user != null) userDao.deleteUser(user);
	}





}
