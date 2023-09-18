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
import com.dnb.jdbcdemo2.exception.IdNotFoundException;
import com.dnb.jdbcdemo2.payload.request.AccountRequest;
import com.dnb.jdbcdemo2.service.AccountService;
import com.dnb.jdbcdemo2.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	@Autowired
	AccountService accountService;
	@Autowired
	RequestToEntityMapper mapper;

	@DeleteMapping("/{accountId}")
	public ResponseEntity<?> deleteAccountByID(@PathVariable("accountId") String accountId) throws IdNotFoundException {
		if (accountService.checkAccountId(accountId)) {
			accountService.deleteAccountByID(accountId);
			return ResponseEntity.noContent().build();
		} else {
			throw new IdNotFoundException("id not");
		}
	}

	@GetMapping("/{accountId}") // it should helps us to get the specific details,accountId is known as path
								// variable
	public ResponseEntity<?> getAccountId(@PathVariable("accountId") String accountId) throws IdNotFoundException {
		Optional<Account> optional = accountService.getAccountById(accountId);
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
//	@GetMapping("/cn/{contactNumber:^[0-9]{10}$}")//it should helps us to get the specific details,accountId is known as path variable
//	public ResponseEntity<?> getAccountByNumber(@PathVariable String contactNumber) throws IdNotFoundException{
//		Optional<Account> optional=accountService.getAccountByContactNumber(contactNumber);
//		if(optional.isPresent()) {
//	return ResponseEntity.ok(optional.get());
//		}else {
//			/*
//			 * // Map<String,String> map=new HashMap<>(); //
//			 * map.put("message","id not found"); //
//			 * map.put("Httpstatus",HttpStatus.NOT_FOUND+""); // ResponseEntity<?>
//			 * responseEntity=new ResponseEntity(map,HttpStatus.NOT_FOUND); // return
//			 * responseEntity; // return ResponseEntity.notFound().build(); //no msg will
//			 * print
//			 */		throw new IdNotFoundException("id not there");
//	}

//}
//	@GetMapping("/allAccounts/{contactNumber:^[0-9]{10}$}")
//
//	public ResponseEntity<?> getAllAccountsByContactNumber(@PathVariable("contactNumber") String contactNumber) throws IdNotFoundException{
//
//		List<Account> list = accountService.getAccountByContactNumber(contactNumber);//change return type in service also
//
//		if(list.size()>0)
//
//		return ResponseEntity.ok(list);
//
//		else
//
//			throw new IdNotFoundException("Provide proper Contact Number.");
//
//	}
//	
//insert or create account:post method:@PostMapping
	@GetMapping("/allAccounts")
	public ResponseEntity<?> getAllAccounts() throws IdNotFoundException {

		List<Account> list = (List<Account>) accountService.getAllAccounts();
		if (list.size() > 0)
			return ResponseEntity.ok(list);
		else
			throw new IdNotFoundException("No details");
	}

	@PostMapping("/create") // @RequestMethod+post method.==>Spring 4.3.x
	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountRequest account) {
		
		Account account2=mapper.getAccountEntityObject(account);
		//return ResponseEntity.ok(mapper.getAccountEntityObject(account));

		try {
			Account account1 = accountService.createAccount(account2);

			return new ResponseEntity(account2, HttpStatus.CREATED);

		} catch (IdNotFoundException e) {

			// TODO Auto-generated catch block

			return ResponseEntity.badRequest().body(e.getMessage());

		}

	}

}
