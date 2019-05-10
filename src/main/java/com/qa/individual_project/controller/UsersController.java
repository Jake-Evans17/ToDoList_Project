package com.qa.individual_project.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.individual_project.model.User;
import com.qa.individual_project.repository.UsersRepository;

@RestController
@RequestMapping("api/v1/")
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<User> list() {
		return usersRepository.findAll();
	}

	@RequestMapping(value = "users", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return usersRepository.saveAndFlush(user);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public User get(@PathVariable int id) {
		return usersRepository.findOne(id);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable int id, @RequestBody User user) {
		User existingUser = usersRepository.findOne(id);
		BeanUtils.copyProperties(user, existingUser);
		return usersRepository.saveAndFlush(user);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public User delete(@PathVariable int id) {
		User existingUser = usersRepository.findOne(id);
		usersRepository.delete(existingUser);
		return existingUser;
	}

	@RequestMapping(value = "users/{username}/{password}", method = RequestMethod.GET)
	public int findByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
		try {
			return usersRepository.findByUsernameAndPassword(username, password).getId();
		} catch (Exception e) {
			return -1;
		}
	}

	@RequestMapping(value = "users/username/{username}", method = RequestMethod.GET)
	public int findByUsername(@PathVariable String username) {
		try {
			return usersRepository.findByUsername(username).getId();
		} catch (Exception e) {
			return -1;
		}
	}
}
