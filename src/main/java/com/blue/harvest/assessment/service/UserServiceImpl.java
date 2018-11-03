package com.blue.harvest.assessment.service;

import java.util.List;

import com.blue.harvest.assessment.model.Customer;
import com.blue.harvest.assessment.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public Customer findById(Long id) {
		return userRepository.findOne(id);
	}

	public Customer findByName(String name) {
		return userRepository.findByName(name);
	}

	public void saveUser(Customer user) {
		userRepository.save(user);
	}

	public void updateUser(Customer user){
		saveUser(user);
	}

	public void deleteUserById(Long id){
		userRepository.delete(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	public List<Customer> findAllUsers(){
		return (List<Customer>) userRepository.findAll();
	}

	public boolean isUserExist(Customer user) {
		return findByName(user.getName()) != null;
	}

}
