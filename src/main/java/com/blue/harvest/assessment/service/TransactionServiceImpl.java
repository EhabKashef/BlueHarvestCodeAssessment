package com.blue.harvest.assessment.service;

import java.util.List;

import com.blue.harvest.assessment.model.Account;
import com.blue.harvest.assessment.model.User;
import com.blue.harvest.assessment.model.Transaction;
import com.blue.harvest.assessment.repositories.AccountRepository;
import com.blue.harvest.assessment.repositories.TransactionRepository;
import com.blue.harvest.assessment.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private AccountService accountService  ;
	@Autowired
	private UserService  userService  ;
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction findById(Long id) {
		return transactionRepository.findOne(id);
	}


	@Override
	public Transaction saveTransaction(Transaction transaction) {
		
 
		transactionRepository.save(transaction);
		
		
	Account account=	accountService.findById(transaction.getAccount().getId());
	User user = 	 userService.findById(account.getUser().getId());
	
	
	user.setId(user.getId());
	user.setAccounts(user.getAccounts());
	user.setName(user.getName());
	user.setSurname(user.getSurname());
	user.setBalance(user.getBalance()+transaction.getAmount());
 
	userService.saveUser(user);
		
		return transaction;
		
	}

	@Override
	public List<Transaction> findByAccountId(Long id) {
		// TODO Auto-generated method stub
		return transactionRepository.findByAccountId(id);
	}

 

	 

 

 

}
