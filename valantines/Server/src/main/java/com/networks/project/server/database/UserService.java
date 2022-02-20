package com.networks.project.server.database;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> list() {
        return repository.findAll();
    }

    public UserService(){}

    public String addNewUser(User user) {
		Optional<User> userOptional = repository.findUserByEmail(user.getEmail());
		if (userOptional.isPresent()) {
			return "fail";
		}
		repository.save(user);
        return "success";
	}
}