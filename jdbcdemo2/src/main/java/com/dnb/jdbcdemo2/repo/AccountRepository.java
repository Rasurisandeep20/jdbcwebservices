package com.dnb.jdbcdemo2.repo;

import java.util.List;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo2.dto.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

	public List<Account> findByContactNumber(String contactNumber);

//	public Account createAccount(Account account);
//	
//	public Optional<Account> getAccountById(String accountId);
//	
//	public boolean deleteAccountById(String accountId);
//	
//	public List<Account> getAllAccounts();
//	
}
