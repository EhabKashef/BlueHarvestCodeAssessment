package com.blue.harvest.assessment.service;


import java.util.List;

import com.blue.harvest.assessment.model.Customer;

public interface UserService {
	
	Customer findById(Long id);

	Customer findByName(String name);

	void saveUser(Customer user);

	void updateUser(Customer user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<Customer> findAllUsers();

	boolean isUserExist(Customer user);
}