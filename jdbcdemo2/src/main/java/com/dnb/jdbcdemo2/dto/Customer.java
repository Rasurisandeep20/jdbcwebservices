package com.dnb.jdbcdemo2.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // implicitly it creates args constructor
@NoArgsConstructor // implicitly it creates default constructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CustomerId;
	private String CustomerName;
	private String CustomercontactNumber;
	private String Customeraddress;
	private String CustomerUUID;
	private String CustomerPAN;
//one customer can have multiple accounts
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="customer")//if we uses eager whenever we wants to retrieve customer details it also gives account details
	private Set<Account> accountList=new HashSet<>();
	
}
