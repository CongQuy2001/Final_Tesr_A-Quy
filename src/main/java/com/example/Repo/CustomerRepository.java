package com.example.Repo;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Entity.Customer;
import com.example.Sevice.Customersevice;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	boolean existsByCustomerName(String customerName);

	boolean existsByIdentityNo(String identityNo);

	Customersevice findByCustomerName(String customerNumber);

	
	@Query("SELECT e FROM Customer e")
	Page<Customer> findCustomers(Pageable pageable);

}
