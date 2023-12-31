package com.project.noteapp.servicesimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.noteapp.entity.User;
import com.project.noteapp.repo.UserRepository;
import com.project.noteapp.services.UserService;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;



	// Creates a new user with the provided details and user roles.
	public User createUser(User user) throws Exception {
		User local = this.userRepository.getUserByEmail(user.getEmail());
		if (local != null) {
			System.out.println("User exists");
			throw new Exception("User already present!");
		} else {
	
			local = this.userRepository.save(user);
			return local;
		}
	}

	// Saves a user in the database.
	public User save(User user) {
		return this.userRepository.save(user);
	}

	// Retrieves a user by their email.
	public User showUser(String email) {
		return this.userRepository.getUserByEmail(email);
	}

	// Retrieves a list of all users.
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
}
