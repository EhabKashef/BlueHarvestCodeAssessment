package com.blue.harvest.assessment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blue.harvest.assessment.model.Customer;
import com.blue.harvest.assessment.service.UserService;


@Component
public class CustomerEntityManagerCommandLineRunner implements CommandLineRunner {
	
	 private static final Logger log = LoggerFactory.getLogger(CustomerEntityManagerCommandLineRunner.class);
	
	 @Autowired
	UserService userService;

	 @Override

	 public void run(String...args) {

		 Customer ehab = new Customer();
		 ehab.setName("Ehab");
		 ehab.setSurname("Ehab Surname"); 
		 ehab.setBalance(0); 
		 userService.saveUser(ehab);

		 
		 Customer luran = new Customer();
		 luran.setName("Luran");
		 luran.setBalance(0); 
		 luran.setSurname("Luran Surname"); 
		 userService.saveUser(luran);
//		 
//		 
		 Customer blue = new Customer();
		 blue.setName("Blue");
		 blue.setBalance(0); 
		 blue.setSurname("Blue Surname"); 
		 userService.saveUser(blue);
		 
		 
		 Customer harvest = new Customer();
		 harvest.setName("Harvest");
		 harvest.setSurname("Harvest Surname"); 
		 harvest.setBalance(0); 
		 userService.saveUser(harvest);
		 
		 
		 
		 
		 
		 
	  log.info("-------------------------------");

	  log.info("Finding all users");

	  log.info("-------------------------------");

	  for (Customer user: userService.findAllUsers()) {

	   log.info(user.toString());

	  }

	 }
	
}
