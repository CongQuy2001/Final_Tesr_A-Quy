package com.example.Sevice.Impl;

import java.awt.print.Pageable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.Dto.ResponseDTO;
import com.example.Entity.Customer;
import com.example.Repo.CustomerRepository;
import com.example.Sevice.Customersevice;


@Service
@Transactional
public class CustomerImpl  implements Customersevice{
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Customer> getAllCustomers() {
		
		return null;
		
//		return customerRepo.findAllByOrderByCustomerNameDesc();
	}

	@Override
	public Page<Customer> pagingCustomer(Pageable pageable) {

		return customerRepo.findCustomers(pageable);
	}

	@Override
	public void deleteById(Long Id) {
	
		customerRepo.deleteById(Id);
	}

	@Override
	public Customer getCustomerById(Long id) {
	
		return customerRepo.findById(id).get();
	}

	@Override
	public ResponseDTO updateCustomer(Customer customer) {
		ResponseDTO respo = new ResponseDTO();
		if (customerRepo.findById(customer.getCustomerId()).equals(null)) {
			respo.setCode("error");
			respo.setMassage("Id is not exists");
			return respo;
		}
		customer.setCustomerName(customer.getCustomerName());
		customer.setAddress(customer.getAddress());
		customer.setCustomertype(customer.getCustomertype());
		customer.setIdentityNo(customer.getIdentityNo());
		customer.setStatus(customer.getStatus());
		respo.setCode("success");
		respo.setMassage("create successfully!");
		respo.setData(customer);
		return respo;
	
	}

	@Override
	public ResponseDTO createCustomer(Customer customer) {
     ResponseDTO rest = new ResponseDTO();
     if(customerRepo.existsByCustomerName(customer.getCustomerName())) {
    	 rest.setCode("error");
    	 rest.setMassage("CustomerName đã tồn tại");
    	 return rest;
     }
     if(customerRepo.existsByIdentityNo(customer.getIdentityNo())) {
    	 rest.setCode("error");
    	 rest.setMassage("IdentityNo đã tồn tại");
    	 return rest;
     }
     rest.setCode("Thành Công");
     rest.setMassage("Thêm mới thành công");
     rest.setData(customer);
     		return rest;
	}


	
	}




	


