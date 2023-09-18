package com.dnb.jdbcdemo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dnb.jdbcdemo2.dto.Account;
import com.dnb.jdbcdemo2.dto.Customer;
import com.dnb.jdbcdemo2.exception.IdNotFoundException;
import com.dnb.jdbcdemo2.repo.AccountRepository;
import com.dnb.jdbcdemo2.repo.CustomerRepository;
@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

@Autowired
//@Qualifier("AccountRepo2Impl")
CustomerRepository customerRepository;
//	public Customer createAccount(Customer customer) {
//		
//		return customerRepository.createCustomer(customer);
//	}
//
//	public Optional<Customer> getCustomerById(int CustomerId) {
//		
//		return customerRepository.getCustomerById(CustomerId);
//	}
//	
//	@Override
//	public String deleteAccount(String CustomerId) {
//		// TODO Auto-generated method stub
//		if(customerRepository.deleteAccountById(CustomerId)==true) {
//			return "REcord has been deleted successfully";
//		}
//		return "Didn't happen";
//	}
//
//	public List<Customer> getAllCustomers() {
//		// TODO Auto-generated method stub
//		return customerRepository.getAllCustomers();
//	}
//
//	public Account createAccount(Account account) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Optional<Account> getAccountById(String accountId) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}
//
//	public List<Account> getAllAccounts() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Customer createCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<Customer> getCustomerById(String CustomerId) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}

@Override
public Customer createCustomer(Customer customer) {
	return customerRepository.save(customer);

}

public Optional<Customer> getCustomerById(Integer CustomerId) {
	// TODO Auto-generated method stub
	return customerRepository.findById(CustomerId);
	
}

public boolean deleteAccountByID(Integer CustomerId) throws IdNotFoundException  {

	// TODO Auto-generated method stub

	boolean isPresent = customerRepository.existsById(CustomerId);

	if(isPresent) {

		customerRepository.deleteById(CustomerId);

		
	}else {

		throw new IdNotFoundException("Id not Found");

	}

	if(customerRepository.existsById(CustomerId))

		return false;

	else

		return true;

	

}

@Override
public Iterable<Customer> getAllCustomers() {
	// TODO Auto-generated method stub
	return customerRepository.findAll();

}



//@Override
//public String deleteAccount(String CustomerId) {
//	// TODO Auto-generated method stub
//	return null;
//}

@Override

public boolean checkCustomerId(int CustomerId) {

	if (customerRepository.existsById(CustomerId))

		return true;

	else

		return false;
}

}

