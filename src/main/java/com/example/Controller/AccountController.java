package com.example.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Account;
import com.example.Sevice.AccountSevice;


@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountSevice accService;

	@GetMapping()
	public ResponseEntity<?> getAllAccounts() {

		return new ResponseEntity<>(accService.getAllAccounts(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") Long id) {

		return new ResponseEntity<Account>(accService.getAccountById(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody Account account) {

		return ResponseEntity.ok(accService.createAccount(account));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccount(@RequestBody @Valid Account account) {
		return ResponseEntity.ok(accService.updateAccount(account));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") Long id) {
		accService.deleteById(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
