package com.example.repository;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.Account;
import com.example.model.TxrHistory;

@Repository("jdbcAccountRepository")
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

	private static final Logger LOGGER = Logger.getLogger("App");

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcAccountRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		LOGGER.info("JdbcAccountRepository created with datasource");
	}

	public Account load(String accNum) {
		LOGGER.info("loading account : " + accNum);
		String sql = "select * from ACCOUNTS where acc_num=?";
		Account account = new Account();
		jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			account.setNumber(rs.getString("acc_num"));
			account.setBalance(rs.getDouble("balance"));
			return account;
		}, accNum);
		return account;
	}

	@Override
	public Account update(Account account) {
		LOGGER.info("updating account : " + account.getNumber());
		String sql = "update ACCOUNTS set balance=? where acc_num=?";
		int rowCount = jdbcTemplate.update(sql, account.getBalance(), account.getNumber());
		return account;
	}

	@Override
	public boolean save(TxrHistory txrHistory) {
		LOGGER.info("saving txr history ");
		String sql = "insert into accounts (txr_id,amount,closing_balance,txr_date,txr_type,acc_num)"
				+ "values(txr_id_seq.nextval,?,?,?,?,?)";
		int n = jdbcTemplate.update(sql, txrHistory.getAmount(),txrHistory.getClosing_balance(),"16-05-19",txrHistory.getTxr_type(),txrHistory.getAcc_num());
		
		
		return n==1;
	}

}
