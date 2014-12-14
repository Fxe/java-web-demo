package me.fxe.web.controller;

import java.util.List;

import me.fxe.User;
import me.fxe.web.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value="/users")
@Controller
public class UserController {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/*
	HTTP	Path				Ctrl#Action		Used for
	GET		/photos				photos#index	display	a list of all photos
	GET		/photos/new			photos#new		return an HTML form for creating a new photo
	POST	/photos				photos#create	create a new photo
	GET		/photos/:id			photos#show		display a specific photo
	GET		/photos/:id/edit	photos#edit		return an HTML form for editing a photo
	PATCH	/photos/:id			photos#update	update a specific photo
	DELETE	/photos/:id			photos#destroy	delete a specific photo
	*/
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<User> getUsers() {
		LOGGER.debug("GET /users /users#index");
		return userService.getUsers();
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") Long id) {
		LOGGER.debug("GET /users/:id /users#show");
		User user = new User();
		user.setId(id);
		user.setFirstName("Jonh");
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody User putUser(User user) {
		LOGGER.debug("POST /users /users#create");
		System.out.println(user);
		
		return user;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Long id) {
		LOGGER.debug("DELETE /users/:id /users#destroy");
		System.out.println(id);
	}
}
