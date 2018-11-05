package com.blue.harvest.assessment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blue.harvest.assessment.model.User;
import com.blue.harvest.assessment.repositories.UserRepository;

 

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {


	@Autowired
	private UserRepository userRepository;
 // check trasnactions after create account
	

	
	
	@Test
	public void createUser_thenGetByName() {
		User user= new User();
		user.setName("Name");
		user.setSurname("Surname");
		
		userRepository.save(user);
		User user1=userRepository.findByName("Name");
		assertNotNull(user1);
	    assertThat(user1.getSurname()).isEqualTo("Surname")
	     ;
	}
	

}




