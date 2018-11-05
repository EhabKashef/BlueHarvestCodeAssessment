package com.blue.harvest.assessment.service;

import java.util.Iterator;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blue.harvest.assessment.model.Account;
import com.blue.harvest.assessment.model.Customer;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {


	@Autowired
	AccountService accountService; //Service which will do all data retrieval/manipulation work

	@Test
	public void whenFindByName_thenReturnEmployee() {

		Account account = new Account();
		account.setInitialCredit(20);
		account.setCustomer(  new Customer().setId(Long.valueOf("1")));
		Account account=	accountService.saveAccount(account)
	    assertThat(account.get)
	      .isEqualTo(alex.getName());
	}

}




