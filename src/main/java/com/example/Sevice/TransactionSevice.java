package com.example.Sevice;

import java.util.List;

import com.example.Entity.Transaction;

public interface TransactionSevice {
	void deleteTransactionById(Long id);

	Transaction CreatebankMoney(Transaction formtransaction);


	List<Transaction> findAllByOrderByTransactionDateDesc(String accountNumber);

	List<Transaction> listTransaction(String from, String to);
}
