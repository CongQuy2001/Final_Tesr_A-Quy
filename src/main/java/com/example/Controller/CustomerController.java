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
import org.springframework.web.bind.annotation.RestController;

import com.example.Sevice.Customersevice;

import com.example.Entity.Customer;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private Customersevice cusService;

	@GetMapping()
	public ResponseEntity<?> getAllCustomers() {

		return new ResponseEntity<>(cusService.getAllCustomers(), HttpStatus.OK);
	}


	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCustomerByID(@PathVariable(name = "id") Long id) {

		return new ResponseEntity<Customer>(cusService.getCustomerById(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {

		return ResponseEntity.ok(cusService.createCustomer(customer));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccount(@RequestBody @Valid Customer customer) {
		return ResponseEntity.ok(cusService.updateCustomer(customer));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(name = "id") Long id) {
		cusService.deleteById(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
