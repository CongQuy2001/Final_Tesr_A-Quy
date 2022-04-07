package com.example.Sevice;

import java.util.List;

import com.example.Dto.ResponseDTO;
import com.example.Entity.Account;

public interface AccountSevice {

	List<Account> getAllAccounts();

	ResponseDTO createAccount(Account account);

	ResponseDTO updateAccount(Account account);

	void deleteById(Long Id);

	Account getAccountById(Long id);

	



}
