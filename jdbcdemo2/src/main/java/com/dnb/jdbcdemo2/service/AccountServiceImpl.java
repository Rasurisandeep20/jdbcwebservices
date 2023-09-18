package com.dnb.jdbcdemo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo2.dto.Account;
import com.dnb.jdbcdemo2.exception.IdNotFoundException;
import com.dnb.jdbcdemo2.repo.AccountRepository;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

	@Autowired // type, name
//	@Qualifier("accountRespository2Impl")
	private AccountRepository accountRepository;
//
//	@Override
//	public Account createAccount(Account account) {
//		Account returndAccount = accountRepositoryImpl.createAccount(account);
//
//		return returndAccount;
//	}
//
//	@Override
//	public Optional<Account> getAccountById(String accountId) {
//		return accountRepositoryImpl.getAccountById(accountId);
//	}
//
//	@Override
//	public List<Account> getAllAccounts() {
//
//		return accountRepositoryImpl.getAllAccounts();
//	}
//
//	public boolean deleteAccountByID(String accountId) {
//
//		return ((AccountServiceImpl) accountRepositoryImpl).deleteAccountByID(accountId);
//	}
//
//	public String deleteAccount(String accountId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId);
	}

//	@Override
//	public Iterable<Account> getAllAccounts() {
//		return accountRepository.findAll();
//		// TODO Auto-generated method stub
//		// return null;
//	}

	public boolean deleteAccountByID(String accountId) throws IdNotFoundException {

		// TODO Auto-generated method stub

		boolean isPresent = accountRepository.existsById(accountId);

		if (isPresent) {

			accountRepository.deleteById(accountId);

		} else {

			throw new IdNotFoundException("Id not Found");

		}

		if (accountRepository.existsById(accountId))

			return false;

		else

			return true;

	}

//public static void deleteAccount() throws IdNotFoundException   {
//
//	Scanner scan = new Scanner(System.in);
//
//	System.out.println("Enter user id to be deleted:");
//
//	String id = scan.next();
//
//	boolean result = deleteAccountByID(id);
//
//	if(result)
//
//		System.out.println("Deleted Successfully!!!");
//
//	else
//
//		System.out.println("Couldn't Happen");
//
//
//
//}
//	@Override
//
//	public boolean checkAccountId(String accountId) {
//
//		if (accountRepository.existsById(accountId))
//
//			return true;
//
//		else
//
//			return false;
//
//	}

//public boolean deleteAccountByID1(String contactNumber) throws IdNotFoundException  {
//
//	// TODO Auto-generated method stub
//
//	boolean isPresent = accountRepository.existsById(contactNumber);
//
//	if(isPresent) {
//
//		accountRepository.deleteById(contactNumber);
//
//		
//	}else {
//
//		throw new IdNotFoundException("Id not Found");
//
//	}
//
//	if(accountRepository.existsById(contactNumber))
//
//		return false;
//
//	else
//
//		return true;
//
//	
//
//}
//public boolean checkNumber(String contactNumber) {
//if(accountRepository.existsById(contactNumber))
//
//	return true;
//
//else
//
//	return false;
//
//}
//	@Override
//	public Optional<Account> getAccountByContactNumber(String contactNumber) {
//		// TODO Auto-generated method stub
//		return accountRepository.findByContactNumber(contactNumber);
//	}
	@Override

	public Iterable<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override

	public boolean checkAccountId(String accountId) {

		if (accountRepository.existsById(accountId))

			return true;

		else

			return false;
	}

	@Override

	public List<Account> getAccountByContactNumber(String contactNumber) {

		// TODO Auto-generated method stub

		return accountRepository.findByContactNumber(contactNumber);

	}

}