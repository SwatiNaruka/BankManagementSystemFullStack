package com.bank.Dao;

import com.bank.Bean.*;

public interface CashOperation {
	OpenAccount getInfo(OpenAccount x);
	 int AddCashDeposit(DepositBean deposit, OpenAccount x);
	 int AddCashWithDraw(WithdrawBean withdraw, OpenAccount x);
}
