package com.bankapp.model.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionLogRepository;
import com.bankapp.model.repo.AccountTransationRepository;
import com.bankapp.model.repo.UserRepository;

public class DataInit implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(DataInit.class);
	
	@Autowired
	public AccountRepository accRepo;
	
	@Autowired
	public AccountTransactionLogRepository accTxLogRepo;
	
	@Autowired
	public AccountTransationRepository accTxRepo;
	

	
	@Autowired
	public UserRepository userRepo;	

	
	@Override
	public void run(String... args) throws Exception {
		/*Address address1 = new Address("Rose Garden","Aranattukara", "Thrissur", "Kerala", "680618");
		Address address2 = new Address("PR Nivas","BTM Layout", "Bangalore", "Karnataka", "11346");
		Address address3 = new Address("Sree Nilayam","MG Road", "Hyderabad", "Telangana", "3448799") ;
		Address address4 = new Address("KR Apartments","KLM Road", "Chennai", "TamilNadu", "566078");
		
		
		Customer customer1 = new Customer("Alna", "alna@a.com", "8287862040", address1 );
		Customer customer2 = new Customer("Anusha", "anusha@a.com", "9867543210",address2 );
		Customer customer3 = new Customer("Sreena", "sreena@s.com", "7689453455",address3);
		Customer customer4 = new Customer("Shylu", "shylu@s.com", "8287862040", address4 );
		
		address1.setCustomer(customer1);
		address2.setCustomer(customer2);
		address3.setCustomer(customer3);
		address4.setCustomer(customer4);
		
		Account account1 = new Account(25000, false, customer1);
		Account account2 = new Account(25000, false, customer2);
		Account account3 = new Account(25000, false, customer3);
		Account account4 = new Account(25000, false, customer4);
		
		customer1.setAccount(account1);
		customer2.setAccount(account2);
		customer3.setAccount(account3);
		customer4.setAccount(account4);
		
		
		
		accRepo.save(account1);
		accRepo.save(account2);
		accRepo.save(account3);
		accRepo.save(account4);
		
		User user1 = new User("Lia", "lia123", "lia@l.com",new String[]{"ROLE_ADMIN","ROLE_MGR","ROLE_CLERK"}, "9845670302", true);
		User user2 = new User("Arjun", "arjun123", "arjun@a.com",new String[]{"ROLE_MGR","ROLE_CLERK"}, "8776238902", true);
		User user3 = new User("Daniel", "daniel123", "daniel@d.com",new String[]{"ROLE_CLERK"}, "9987654321", true);

		
		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);*/
		
		
	
	}

}

