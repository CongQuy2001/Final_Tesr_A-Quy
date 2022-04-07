package com.example.Sevice;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.Dto.ResponseDTO;
import com.example.Entity.Customer;

public interface Customersevice {
	List<Customer> getAllCustomers();

	Page<Customer> pagingCustomer(Pageable pageable);

	void deleteById(Long Id);

	Customer getCustomerById(Long id);

	ResponseDTO updateCustomer(Customer customer);

	ResponseDTO createCustomer(Customer customer);



}
