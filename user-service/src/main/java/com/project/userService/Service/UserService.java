package com.project.userService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.userService.Entity.User;
import com.project.userService.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User register(User user) { 
		return repo.save(user);
	}
	
	public User getUser(Long id) {
		return repo.findById(id)
				.orElseThrow(()-> new RuntimeException("user not found"));
	}
}
