package com.example.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByAccountNumber(String accountNumber);

	boolean existsByAccountNumber(String accountNumber);
}
