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

import com.blue.harvest.assessment.model.Transaction;
import com.blue.harvest.assessment.model.User;
import com.blue.harvest.assessment.service.TransactionService;
import com.blue.harvest.assessment.service.UserService;
import com.blue.harvest.assessment.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class TransactionController {

	public static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	TransactionService transactionService; //Service which will do all data retrieval/manipulation work

 



//
	// -------------------Retrieve Single Transaction------------------------------------------

	@RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTransaction(@PathVariable("id") long id) {
		logger.info("Fetching Transaction with id {}", id);
		Transaction transaction = transactionService.findById(id);
		if (transaction == null) {
			logger.error("Transaction with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Transaction with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	
	// -------------------Retrieve Transactions By AccountId------------------------------------------

	@RequestMapping(value = "/transactions/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<?> getTransactionByAccountId(@PathVariable("accountId") long id) {
		logger.info("Fetching Transaction with id {}", id);
		List<Transaction> transactions = transactionService.findByAccountId(id);
				
	//	List<Customer> users = userService.findAllUsers();
		if (transactions.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND<List<Customer>>
		}
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}


	// -------------------Create a Transaction-------------------------------------------

	@RequestMapping(value = "/transaction/", method = RequestMethod.POST)
	public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Transaction : {}", transaction);


		Transaction newTransaction = transactionService.saveTransaction(transaction);

	 
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/transaction/{id}").buildAndExpand(newTransaction.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

 

}