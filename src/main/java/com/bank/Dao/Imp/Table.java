package com.bank.Dao.Imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.Dao.*;


import com.bank.Bean.*;
import com.bank.Dao.AccountTableData;

public class Table implements AccountTableData{
	static Connection con;
		public List<OpenAccount> table() {
			con = DbConnection.getConnection();
		 	
		 	try {
				Statement stmt=con.createStatement();
				String  sql ="select *from AllAccount";
				ResultSet rs = stmt.executeQuery(sql);
				
				List<OpenAccount> list =new ArrayList<OpenAccount>();
				
				while(rs.next()) {
					OpenAccount x =new OpenAccount();
					x.setACno(Integer.parseInt(rs.getString(1)));
					x.setName(rs.getString(2));
					x.setFatherName(rs.getString(3));
					x.setGender(rs.getString(4));
					x.setMeritalStatus(rs.getString(5));
					x.setTypeOfAc(rs.getString(6));
					x.setDOB(rs.getString(7));
					x.setServiseRequired(rs.getString(8));
					x.setAmount(Integer.parseInt(rs.getString(9)));
					x.setPhotoName(rs.getString(10));
					list.add(x);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	 }
		
		 public  List<StatementBean> statementTable(StatementBean x){
			 con = DbConnection.getConnection();
			 try {
					Statement stmt=con.createStatement();
					
					//String sql ="select *from finaleStatement where ((DepositDate between '"+x.getStartDate()+"' and '"+x.getEndDate()+"') or (WithdrawDate between '"+x.getStartDate()+"' and '"+x.getEndDate()+"')) and AccNo = "+x.getAccNo()+"";
					String sql = "select *from transction where (transctionDate between '"+x.getStartDate()+"' and '"+x.getEndDate()+"') and AccNo = "+x.getAccNo()+"";
					ResultSet rs = stmt.executeQuery(sql);
					
					List<StatementBean> list =new ArrayList<StatementBean>();
					while(rs.next()) {
					//	x.setDebitDate(rs.getString(4));
						//x.set
						StatementBean obj =new StatementBean();
						  obj.setAccNo(Integer.parseInt(rs.getString(1)));					  
						  obj.setTransactionDate(rs.getString(2));
						  obj.setTransctionId(Integer.parseInt(rs.getString(3)));					  
						  obj.setDepositBal(Integer.parseInt(rs.getString(4)));					  
						  obj.setWithdrawbal(Integer.parseInt(rs.getString(5)));
						  obj.setAccountBal(Integer.parseInt(rs.getString(6)));
						  
						 					
					list.add(obj);
					}
			
					return list;
			 	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			
		 }
		 
		 public DashBoard count() {
			 con = DbConnection.getConnection();
			 
			 try {
				Statement stmt=con.createStatement();
				String sql="select count(*) from allaccount;";
				ResultSet rs =stmt.executeQuery(sql);
				DashBoard obj=new DashBoard();
				while(rs.next()){
				//	System.out.println(rs.getInt(1));
					obj.setNum(rs.getInt(1));									
				}
				
				return obj;
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 return null;
			}
			 
			 
			
		 }
		 
		 public DashBoard calculateDate(DashBoard b) {
			 con=DbConnection.getConnection();
			try {
				Statement stmt= con.createStatement();
				String sql ="select count(transctionDate) from transction where transctionDate between '"+b.getA()+"' AND '"+b.getB()+"';";
				ResultSet rs= stmt.executeQuery(sql);
				
				
				while(rs.next()) {
					//System.out.println(rs.getString(1));
					b.setNum(Integer.parseInt(rs.getString(1)));
				}
				return b;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			 
			 
			 
			
			 
		 }
	
		
		
		
}
