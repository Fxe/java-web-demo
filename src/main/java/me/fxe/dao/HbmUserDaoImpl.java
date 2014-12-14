package me.fxe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.fxe.User;

@Repository
public class HbmUserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public HbmUserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<> ();
		return users;
	}

	@Override
	public User getUser(long id) {
		Object user_ = sessionFactory.getCurrentSession().get(User.class, id);
		if (user_ == null) return null;
		
		return User.class.cast(user_);
	}
	
	@Override
	public User saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	@Override
	public void updateUser(User user) {
		if (user != null) sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(User user) {
		if (user != null) sessionFactory.getCurrentSession().delete(user);
	}



}
