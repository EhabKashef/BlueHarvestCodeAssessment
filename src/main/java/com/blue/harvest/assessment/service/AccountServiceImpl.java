package com.blue.harvest.assessment.service;

import java.util.List;

import com.blue.harvest.assessment.dto.AccountDTO;
import com.blue.harvest.assessment.model.Account;
import com.blue.harvest.assessment.model.Customer;
import com.blue.harvest.assessment.repositories.AccountRepository;
import com.blue.harvest.assessment.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Account findById(Long id) {
		return accountRepository.findOne(id);
	}

	@Override
	public void deleteAccountById(Long id) {
		accountRepository.delete(id);
		
	}

	@Override
	public void deleteAllAccount() {
		accountRepository.deleteAll();
		
	}

	@Override
	public List<Account> findAllAccount() {
		return (List<Account>) accountRepository.findAll();
	}



	@Override
	public Account saveAccount(AccountDTO account) {
		
	
		
		Account account1 = new Account();
		account1.setInitialCredit(account.getInitialCredit());
		Customer user = new Customer();
		user.setId(account.getCustomerID());
		account1.setUser(user);
		accountRepository.save(account1);
		return account1;
		
	}

	@Override
	public List<Account> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return accountRepository.findByUserId(id);
	}



//	@Override
//	public void updateAccount(Account account) {
//		saveAccount(account);
//		
//	}


	 

 

 

}
