package com.blue.harvest.assessment.service;


import java.util.List;

import com.blue.harvest.assessment.dto.AccountDTO;
import com.blue.harvest.assessment.model.Account;
import com.blue.harvest.assessment.model.Transaction;


public interface TransactionService {
	
	Transaction findById(Long id);

	List<Transaction> findByAccountId(Long id);

	Transaction saveTransaction(Transaction transaction);

 

}