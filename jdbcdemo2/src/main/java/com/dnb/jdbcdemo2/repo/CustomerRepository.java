package com.dnb.jdbcdemo2.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.jdbcdemo2.dto.Account;
import com.dnb.jdbcdemo2.dto.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

//	public Customer createCustomer(Customer customer);
//	
//	public Optional<Customer> getCustomerById(int customerId);
//	
//
//	
//	public List<Customer> getAllCustomers();
//
//	public boolean deleteAccountById(String customerId);

}