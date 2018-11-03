package com.blue.harvest.assessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blue.harvest.assessment.model.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String name);

}
