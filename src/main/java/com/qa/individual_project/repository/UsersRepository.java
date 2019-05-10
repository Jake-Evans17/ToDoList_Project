package com.qa.individual_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.individual_project.model.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);

}
