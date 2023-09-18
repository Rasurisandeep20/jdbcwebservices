package com.dnb.jdbcdemo2.utils;

import org.springframework.stereotype.Component;

import com.dnb.jdbcdemo2.dto.Account;
import com.dnb.jdbcdemo2.dto.Customer;
import com.dnb.jdbcdemo2.payload.request.AccountRequest;
import com.dnb.jdbcdemo2.payload.request.CustomerRequest;

@Component
public class RequestToEntityMapper {

	public Account getAccountEntityObject(AccountRequest accountRequest) {
		Account account=new Account();
		account.setAccountHolderName(accountRequest.getAccountHolderName());
		account.setAccountType(accountRequest.getAccountHolderName());
		account.setAddress(accountRequest.getAddress());
		account.setBalance(accountRequest.getBalance());
		account.setContactNumber(accountRequest.getContactNumber());
		account.setDob(accountRequest.getDob());
		//account.setCustomerId(accountRequest.getCustomerId());
		
		return account;
	}
	public Customer getCustomerEntityObject(CustomerRequest customerRequest) {

		Customer customer=new Customer();
		customer.setCustomerName(customerRequest.getCustomerName());
		customer.setCustomercontactNumber(customerRequest.getCustomercontactNumber());
		customer.setCustomeraddress(customerRequest.getCustomeraddress());
		customer.setCustomerPAN(customerRequest.getCustomerPAN());
		customer.setCustomerUUID(customerRequest.getCustomerUUID());
	    return customer;
	}
}
