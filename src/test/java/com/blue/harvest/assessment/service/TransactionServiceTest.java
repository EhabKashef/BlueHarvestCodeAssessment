package com.blue.harvest.assessment.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blue.harvest.assessment.dto.AccountDTO;
import com.blue.harvest.assessment.model.Account;
import com.blue.harvest.assessment.model.Transaction;
import com.blue.harvest.assessment.model.User;

  

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {


	@Autowired
	AccountService accountService; //Service which will do all data retrieval/manipulation work

	@Autowired
	TransactionService transactionService; //Service which will do all data retrieval/manipulation work

 // check trasnactions after create account
	

	
	
	@Test
	public void checkCustomerBalanceAfterTransaction() {

		AccountDTO account = new AccountDTO();
		account.setCustomerID(2);
		Account account1 =	accountService.saveAccount(account);
		
		Transaction transaction= new Transaction();
		transaction.setAccount(account1);
		transaction.setAmount(30);
		transactionService.saveTransaction(transaction) ;// findByAccountId(account1.getId());
		account1 = accountService.findById(account1.getId());
	    assertEquals(Double.valueOf( account1.getUser().getBalance()), Double.valueOf(30));
	     
	}
	

}




