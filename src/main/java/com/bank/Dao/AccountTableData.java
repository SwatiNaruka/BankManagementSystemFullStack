package com.bank.Dao;

import java.util.List;

import com.bank.Bean.*;


public interface AccountTableData {
	List<OpenAccount>table();
	List<StatementBean> statementTable(StatementBean x);
	
	
}
