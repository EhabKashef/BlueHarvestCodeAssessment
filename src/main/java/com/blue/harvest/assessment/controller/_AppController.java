package com.blue.harvest.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blue.harvest.assessment.model.Account;
import com.blue.harvest.assessment.model.Transaction;
import com.blue.harvest.assessment.service.AccountService;
import com.blue.harvest.assessment.service.TransactionService;

 
 
 
@Controller
public class _AppController {

	
	@Autowired
	AccountService accountService; //Service which will do all data retrieval/manipulation work
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("title","Blue Harvest");
		return "customer";
	}

	
 

	
	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}
	
	@RequestMapping("/getaccounts/{id}")
	String accounts(ModelMap modal,@PathVariable("id") final Long id) {
		modal.addAttribute("title","Blue Harvest");
		 List<Account> accounts = accountService.findByUserId(id);
	 	modal.addAttribute("accounts",accounts);
	 	modal.addAttribute("id",id);
		return "accountList";
	}
	
	@RequestMapping("/gettransactins/{id}")
	String transactins(ModelMap modal,@PathVariable("id") final Long id) {
		
		modal.addAttribute("title","Blue Harvest");
		 //Service which will do all data retrieval/manipulation work
		List<Transaction> transactions = transactionService.findByAccountId(id);
	 


	 	modal.addAttribute("transactions",transactions);
	 	modal.addAttribute("id",id);
		return "transactions";
	}
	
	

}
