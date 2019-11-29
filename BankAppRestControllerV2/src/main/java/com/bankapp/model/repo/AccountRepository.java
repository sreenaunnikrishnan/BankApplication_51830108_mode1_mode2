package com.bankapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	public Customer findByCustomerName(String name);
	public Customer findByCustomerCustomerId(Long custId);

}
