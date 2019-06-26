package com.example.repository;

import com.example.model.Account;
import com.example.model.TxrHistory;

public interface AccountRepository {

	Account load(String accNum);

	Account update(Account account);

	boolean save(TxrHistory txrHistory);

}