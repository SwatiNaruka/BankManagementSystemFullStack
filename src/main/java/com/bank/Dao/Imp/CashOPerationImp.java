package com.bank.Dao.Imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.bank.Bean.DepositBean;
import com.bank.Bean.OpenAccount;
import com.bank.Bean.WithdrawBean;
import com.bank.Dao.CashOperation;
import com.bank.Dao.DbConnection;

public class CashOPerationImp implements CashOperation{
	static Connection con;
	public OpenAccount getInfo(OpenAccount x) {
		con =DbConnection.getConnection();
		try {
			
			Statement stmt=con.createStatement();
			String sql = "select AccNo, Name, Amount from AllAccount where AccNo = "+x.getACno()+"";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				x.setACno(Integer.parseInt(rs.getString(1)));
				x.setName(rs.getString(2));
				x.setAmount(Integer.parseInt(rs.getString(3)));;
				System.out.println(x.getName());
			}
			return x;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static  int CashUpdation(OpenAccount x){
		////AddCashDeposit(deposit);
		
		con = DbConnection.getConnection( );
		try {
			Statement stmt=con.createStatement();
			String sql = "update AllAccount set Amount = "+x.getAmount()+" where AccNo = "+x.getACno()+"";
				int status=	stmt.executeUpdate(sql);				
				return status;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return 0;
		}
		
	}
	
	
	
	public int AddCashDeposit(DepositBean deposit, OpenAccount x) {
		// TODO Auto-generated method stub
		try {
			Statement stmt=con.createStatement();
		//	String sql ="insert into cashDeposit values(0,"+deposit.getBalance()+",'"+deposit.getDate()+"',"+deposit.getAccno()+")";
			String sql1 = "insert into transction(AccNo,transctionDate,depositAmount,withdrawAmount,Balance) values("+deposit.getAccno()+",'"+deposit.getDate()+"',"+deposit.getBalance()+","+deposit.getWithdrawBalance()+" ,"+x.getAmount()+")"; 
			
			int status =stmt.executeUpdate(sql1);
			int result =CashUpdation(x);
				if(result == 1) {
					status++;
				}
			return status;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return 0;
		}
	}
	
	public  int AddCashWithDraw(WithdrawBean withdraw, OpenAccount x) {
		try {
			Statement stmt=con.createStatement();
			//String sql ="insert into cashwithdraw values(0,"+withdraw.getBalance()+",'"+withdraw.getDebitDate()+"',"+withdraw.getAccNo()+")";
			String sql = "insert into transction(AccNo,transctionDate,withdrawAmount,depositAmount,Balance) values("+withdraw.getAccNo()+",'"+withdraw.getDebitDate()+"',"+withdraw.getBalance()+", "+withdraw.getDepositBalance()+","+x.getAmount()+")";
			
			int status =stmt.executeUpdate(sql);
			int result =CashUpdation(x);
				if(result == 1) {
					status++;
				}
			return status;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return 0;
		}
	}

}
