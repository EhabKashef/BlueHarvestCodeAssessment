package com.blue.harvest.assessment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.blue.harvest.assessment.dto.AccountDTO;
import com.blue.harvest.assessment.model.Account;
import com.blue.harvest.assessment.model.Customer;
import com.blue.harvest.assessment.service.AccountService;
import com.blue.harvest.assessment.service.UserService;
import com.blue.harvest.assessment.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	AccountService accountService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Accounts---------------------------------------------

	@RequestMapping(value = "/account/", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> listAllAccounts() {
		List<Account> accounts = accountService.findAllAccount();
		if (accounts.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}
//
	// -------------------Retrieve Single Account------------------------------------------

	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAccount(@PathVariable("id") long id) {
		logger.info("Fetching Account with id {}", id);
		Account account = accountService.findById(id);
		if (account == null) {
			logger.error("Account with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Account with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	
	// -------------------Retrieve Accounts By CustomerId------------------------------------------

	@RequestMapping(value = "/accounts/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAccountByCustomerId(@PathVariable("customerId") long id) {
		logger.info("Fetching Account with id {}", id);
		List<Account> accounts = accountService.findByUserId(id);
				
	//	List<Customer> users = userService.findAllUsers();
		if (accounts.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND<List<Customer>>
		}
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}


	// -------------------Create a Account-------------------------------------------

	@RequestMapping(value = "/account/", method = RequestMethod.POST)
	public ResponseEntity<?> createAccount(@RequestBody AccountDTO account, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Account : {}", account);


		Account newAccount = accountService.saveAccount(account);

		if(newAccount==null)
		{
			
			logger.error("Account with id {} not found.", account.getCustomerID() );
			return new ResponseEntity(new CustomErrorType("Account with id " + account.getCustomerID() 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/account/{id}").buildAndExpand(newAccount.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	

}