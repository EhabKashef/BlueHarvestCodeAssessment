package com.blue.harvest.assessment.service;


import java.util.List;

import com.blue.harvest.assessment.dto.AccountDTO;
import com.blue.harvest.assessment.model.Account;


public interface AccountService {
	
	Account findById(Long id);

	List<Account> findByUserId(Long id);

	Account saveAccount(AccountDTO account);


	List<Account> findAllAccount();

}