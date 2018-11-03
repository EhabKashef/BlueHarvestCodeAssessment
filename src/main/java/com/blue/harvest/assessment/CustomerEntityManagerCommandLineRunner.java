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
		 ehab.setAge(29);
		 ehab.setSalary(3000);
		 userService.saveUser(ehab);

		 
		 Customer luran = new Customer();
		 luran.setName("Luran");
		 luran.setAge(23);
		 luran.setSalary(3500);
		 userService.saveUser(luran);
//		 
//		 
		 Customer blue = new Customer();
		 blue.setName("Blue");
		 blue.setAge(22);
		 blue.setSalary(1000);
		 userService.saveUser(blue);
		 
		 
		 Customer harvest = new Customer();
		 harvest.setName("Harvest");
		 harvest.setAge(30);
		 harvest.setSalary(4000);
		 userService.saveUser(harvest);
		 
		 
		 
		 
		 
		 
	  log.info("-------------------------------");

	  log.info("Finding all users");

	  log.info("-------------------------------");

	  for (Customer user: userService.findAllUsers()) {

	   log.info(user.toString());

	  }

	 }
	
}
