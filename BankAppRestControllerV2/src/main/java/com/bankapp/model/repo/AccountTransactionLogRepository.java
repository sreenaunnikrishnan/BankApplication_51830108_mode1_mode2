package com.bankapp.model.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.AccountTransactionLog;


@Repository
public interface AccountTransactionLogRepository extends JpaRepository<AccountTransactionLog, Long>{
	//find all tx between two given date
		//find all tx which contain account id 121
	@Query(value="select * from transaction_log_table where time_stamp between :fromDate and :toDate",nativeQuery=true)
	public List<AccountTransactionLog> getTransactionLogByDate(@Param("fromDate")LocalDateTime fromDate,@Param("toDate")LocalDateTime toDate);
}
