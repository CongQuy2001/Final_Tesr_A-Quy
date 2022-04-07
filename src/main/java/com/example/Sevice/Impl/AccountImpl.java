package com.example.Sevice.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.ResponseDTO;
import com.example.Entity.Account;
import com.example.Repo.AccountRepository;
import com.example.Sevice.AccountSevice;


@Service
@Transactional
public class AccountImpl implements AccountSevice {

	@Autowired
	private AccountRepository accountRepo;
	@Override
	public List<Account> getAllAccounts() {
		
		return accountRepo.findAll();
	}

	@Override
	public ResponseDTO createAccount(Account account) {
		
		ResponseDTO respo = new ResponseDTO();
		String massage = "accountNumber is exists! or accountNumber small 9";
		if (accountRepo.existsByAccountNumber(account.getAccountNumber()) || account.getAccountNumber().length() < 9) {
			respo.setCode("error");
			respo.setMassage(massage);
			return respo;
		} else {

			account = accountRepo.save(account);
			respo.setCode("success");
			respo.setMassage("create successfully!");
			respo.setData(account);
			return respo;
		}
	}

	@Override
	public ResponseDTO updateAccount(Account account) {
		
		ResponseDTO respo = new ResponseDTO();
		if (accountRepo.findById(account.getAccountId()).equals(null)) {
			respo.setCode("error");
			respo.setMassage("Id is not exstis");
			return respo;
		}
		account.setAccountNumber(account.getAccountNumber());
		account.setBalance(account.getBalance());
		account.setStatus(account.getStatus());
		respo.setCode("succses");
		respo.setMassage("Update succsesfully!");
		respo.setData(respo);

		return respo;
	}

	@Override
	public void deleteById(Long Id) {
	
		accountRepo.deleteById(Id);
	}

	@Override
	public Account getAccountById(Long id) {
	
		return accountRepo.findById(id).get();
	}



	

}
