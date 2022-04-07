//package com.example.Sevice.Impl;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.apache.tomcat.util.bcel.classfile.Constant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.Entity.Account;
//import com.example.Entity.Transaction;
//import com.example.Repo.AccountRepository;
//import com.example.Repo.TransactionReposiory;
//import com.example.Sevice.Customersevice;
//import com.example.Sevice.TransactionSevice;
//@Service
//@Transactional
//public class TransactionImpl implements TransactionSevice {
//	@Autowired
//	private TransactionReposiory repository;
//
//	@Autowired
//	private AccountRepository accRepo;
//	@Override
//	public void deleteTransactionById(Long id) {
//		repository.deleteById(id);
//		
//	}
//
//	@Override
//	public Transaction CreatebankMoney(Transaction formtransaction) {
//		Account fromAccount = accRepo.findById(formtransaction.getFromAccount()).orElse(null);
//		Account toAccount = accRepo.findById(formtransaction.getToAccount()).orElse(null);
//
//		Transaction transaction = new Transaction();
//
//		transaction.setAmount(formtransaction.getAmount());
//		transaction.setContent(formtransaction.getContent());
//		transaction.setFromAccount(fromAccount);
//		transaction.setToAccuont(toAccount);
////
//		if (fromAccount.getStatus() == Constant.ACCOUNT_STATUS_HET_HIEU_LUC
//				|| toAccount.getStatus() == Constant.ACCOUNT_STATUS_HET_HIEU_LUC) {
//			transaction.setErrorReason("Error:fromAccount or toAccount is expire, please checked!");
//			transaction.setStatus(Constant.ACCOUNT_STATUS_HET_HIEU_LUC);
//		}
//		if (fromAccount.getBalance() < (formtransaction.getToAccount())) {
//			transaction.setErrorReason("fromAccount insufficient balance! plesae recharge monney!");
//			transaction.setStatus(Constant.TRANSACTION_STATUS_FAIL);
//		}
//		fromAccount.setBalance(fromAccount.getBalance() - formtransaction.getAmount());
//		toAccount.setBalance(toAccount.getBalance() + formtransaction.getAmount());
//		transaction.setErrorReason("SUCCESS");
//		transaction.setStatus(Constant.TRANSACTION_STATUS_SUCCESS);
//		return repository.save(transaction);
//	}
//		return null;
//	
//
//	@Override
//	public List<Transaction> findAllByOrderByTransactionDateDesc(String accountNumber) {
//		String message = "";
//		try {
//			if (!accRepo.existsByAccountNumber(accountNumber)) {
//
//				message += "accountNumber not exists!";
//			} else {
//				Transaction transaction = null;
//				transaction.setTransactionDate(transaction.getTransactionDate());
//
//				repository.findAllByOrderByTransactionDateDesc();
//			}
//		} catch (Exception e) {
//			message += e.getMessage();
//		}
//
//		return null;
//	
//	}
//
//	@Override
//	public List<Transaction> listTransaction(String from, String to) {
//		LocalDate localDatefrom = null;
//		LocalDate localDateto = null;
//		String fromdate = from.replace("-", "/");
//		String todate = to.replace("-", "/");
//
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
//
//		if (from != null && !from.isEmpty()) {
//			localDatefrom = LocalDate.parse(fromdate);
//		}
//		if (to != null && !to.isEmpty()) {
//			localDateto = LocalDate.parse(todate);
//		}
//		return repository.listTransaction(localDatefrom, localDateto);
//	}
//	}
//	}
//
//	
//
//
