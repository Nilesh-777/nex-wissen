package com.example.model;

import java.time.LocalDateTime;

public class TxrHistory {
private int txr_id;
private double amount;
private double closing_balance;
private LocalDateTime txr_date;
private TxrType txr_type;
	private String acc_num;

	public int getTxr_id() {
		return txr_id;
	}

	public void setTxr_id(int txr_id) {
		this.txr_id = txr_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getClosing_balance() {
		return closing_balance;
	}

	public void setClosing_balance(double closing_balance) {
		this.closing_balance = closing_balance;
	}

	public LocalDateTime getTxr_date() {
		return txr_date;
	}

	public void setTxr_date(LocalDateTime txr_date) {
		this.txr_date = txr_date;
	}

	public TxrType getTxr_type() {
		return txr_type;
	}

	public void setTxr_type(TxrType txr_type) {
		this.txr_type = txr_type;
	}

	public String getAcc_num() {
		return acc_num;
	}

	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}


}
