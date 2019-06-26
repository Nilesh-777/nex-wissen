package com.example.service;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.model.TxrHistory;
import com.example.model.TxrType;
import com.example.repository.AccountRepository;

import oracle.net.nt.TcpsConfigure;

public class TxrServiceImpl implements TxrService {

	private static final Logger LOGGER = Logger.getLogger("App");

	private AccountRepository accountRepository;

	public TxrServiceImpl() {
		LOGGER.info("TxrServiceImpl created");
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		LOGGER.info("TxrServiceImpl got injection with accountRepository");
	}

	@Transactional
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		LOGGER.info("Txr initiated");
		Account fromAccount = accountRepository.load(fromAccNum);
		Account toAccount = accountRepository.load(toAccNum);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.update(fromAccount);
		TxrHistory txrHistory = new TxrHistory();
		txrHistory.setAcc_num(fromAccNum);
		txrHistory.setAmount(amount);
		txrHistory.setClosing_balance(fromAccount.getBalance());
		txrHistory.setTxr_type(TxrType.DEBIT);
		txrHistory.setTxr_date(LocalDateTime.now());
		accountRepository.save(txrHistory);

		accountRepository.update(toAccount);
		txrHistory.setAcc_num(toAccNum);
		txrHistory.setAmount(amount);
		txrHistory.setClosing_balance(toAccount.getBalance());
		txrHistory.setTxr_type(TxrType.CREDIT);
		txrHistory.setTxr_date(LocalDateTime.now());

		boolean b = false;
		if (b)
			throw new RuntimeException("ooops");
		accountRepository.update(toAccount);

		LOGGER.info("Txr finished");

		return true;

	}

}
