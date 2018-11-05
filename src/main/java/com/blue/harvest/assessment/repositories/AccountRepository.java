package com.blue.harvest.assessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blue.harvest.assessment.model.Account;
import com.blue.harvest.assessment.model.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByUserId(Long id);
}
