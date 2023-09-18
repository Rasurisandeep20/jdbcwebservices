package com.dnb.jdbcdemo2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.jdbcdemo2.dto.Account;
import com.dnb.jdbcdemo2.dto.Customer;
import com.dnb.jdbcdemo2.exception.IdNotFoundException;
import com.dnb.jdbcdemo2.payload.request.CustomerRequest;
import com.dnb.jdbcdemo2.service.AccountService;
import com.dnb.jdbcdemo2.service.CustomerService;
import com.dnb.jdbcdemo2.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@Autowired
	RequestToEntityMapper mapper;

	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteAccountByID(@PathVariable("customerId") int CustomerId) throws IdNotFoundException {
		if (customerService.checkCustomerId(CustomerId)) {
			customerService.deleteAccountByID(CustomerId);
			return ResponseEntity.noContent().build();
		} else {
			throw new IdNotFoundException("id not");
		}
	}

	@GetMapping("/allCustomers")
	public ResponseEntity<?> getAllAccounts() throws IdNotFoundException {

		List<Customer> list = (List<Customer>) customerService.getAllCustomers();
		if (list.size() > 0)
			return ResponseEntity.ok(list);
		else
			throw new IdNotFoundException("No details");
	}

	@PostMapping("/create") // @RequestMethod+post method.==>Spring 4.3.x
	public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerRequest customer) {
		Customer customer1 = mapper.getCustomerEntityObject(customer);
		try {
			Customer customer2 = customerService.createCustomer(customer1);

			return new ResponseEntity<Customer>(customer2, HttpStatus.CREATED);

		} catch (IdNotFoundException e) {

			// TODO Auto-generated catch block

			return ResponseEntity.badRequest().body(e.getMessage());

		}

	}

	@GetMapping("/{CustomerId}") // it should helps us to get the specific details,accountId is known as path
	// variable
	public ResponseEntity<?> getAccountId(@PathVariable("CustomerId") int CustomerId) throws IdNotFoundException {
		Optional<Customer> optional = customerService.getCustomerById(CustomerId);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			/*
			 * // Map<String,String> map=new HashMap<>(); //
			 * map.put("message","id not found"); //
			 * map.put("Httpstatus",HttpStatus.NOT_FOUND+""); // ResponseEntity<?>
			 * responseEntity=new ResponseEntity(map,HttpStatus.NOT_FOUND); // return
			 * responseEntity; // return ResponseEntity.notFound().build(); //no msg will
			 * print
			 */ throw new IdNotFoundException("id not there");
		}

	}
}
