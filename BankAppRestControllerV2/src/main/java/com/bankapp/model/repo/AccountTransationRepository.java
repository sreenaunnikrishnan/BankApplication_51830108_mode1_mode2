package com.bankapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;


@Repository
public interface AccountTransationRepository extends JpaRepository<AccountTransaction, Long>{

	List<AccountTransaction> findAll();
    List<AccountTransaction> findByAccountAccountNumber(Long accountNumber);

}
