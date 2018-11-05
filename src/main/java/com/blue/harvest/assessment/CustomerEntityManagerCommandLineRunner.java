package com.blue.harvest.assessment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blue.harvest.assessment.model.User;
import com.blue.harvest.assessment.service.UserService;


@Component
public class CustomerEntityManagerCommandLineRunner implements CommandLineRunner {
	
	 private static final Logger log = LoggerFactory.getLogger(CustomerEntityManagerCommandLineRunner.class);
	
	 @Autowired
	UserService userService;

	 @Override

	 public void run(String...args) {

		 User ehab = new User();
		 ehab.setName("Ehab");
		 ehab.setSurname("Ehab Surname"); 
		 ehab.setBalance(0); 
		 userService.saveUser(ehab);

		 
		 User luran = new User();
		 luran.setName("Luran");
		 luran.setBalance(0); 
		 luran.setSurname("Luran Surname"); 
		 userService.saveUser(luran);
//		 
//		 
		 User blue = new User();
		 blue.setName("Blue");
		 blue.setBalance(0); 
		 blue.setSurname("Blue Surname"); 
		 userService.saveUser(blue);
		 
		 
		 User harvest = new User();
		 harvest.setName("Harvest");
		 harvest.setSurname("Harvest Surname"); 
		 harvest.setBalance(0); 
		 userService.saveUser(harvest);
		 
		 
		 
		 
		 
		 
	  log.info("-------------------------------");

	  log.info("Finding all users");

	  log.info("-------------------------------");

	  for (User user: userService.findAllUsers()) {

	   log.info(user.toString());

	  }

	 }
	
}
