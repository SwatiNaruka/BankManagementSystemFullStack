package com.bank.Dao.Imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.Bean.OpenAccount;
import com.bank.Dao.*;

public class AccountForm implements OpenAccForm {
	static Connection con;

	public int submitFormData(OpenAccount x) {
		// TODO Auto-generated method stub
		con =DbConnection.getConnection();
		
		try {
			Statement stmt=con.createStatement();
			String sql = "insert into AllAccount value("+x.getACno()+",'"+x.getName()+"','"+x.getFatherName()+"','"+x.getGender()+"','"+x.getMeritalStatus()+"','"+x.getTypeOfAc()+"','"+x.getDOB()+"','"+x.getServiseRequired()+"',"+x.getAmount()+",'"+x.getPhotoName()+"')";
			//insert into dept value("+d.getDept_id()+",'"+d.getDeptName()+"')";
			int status = stmt.executeUpdate(sql);							
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int DeleteAccount(OpenAccount x) {
		con =DbConnection.getConnection();
		try {
			Statement stmt =con.createStatement();
			String sql ="delete from AllAccount where AccNo = "+x.getACno()+"";
			
			int status = stmt.executeUpdate(sql);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	public OpenAccount getAccountDetail(OpenAccount a) {
		con = DbConnection.getConnection();
	 	
	 	try {
			Statement stmt=con.createStatement();
			String  sql ="select *from AllAccount where AccNo= "+a.getACno()+"";
			ResultSet rs = stmt.executeQuery(sql);
			
		//	List<OpenAccount> list =new ArrayList<OpenAccount>();
			
			while(rs.next()) {
				//OpenAccount x =new OpenAccount();
				a.setACno(Integer.parseInt(rs.getString(1)));
				a.setName(rs.getString(2));
				a.setFatherName(rs.getString(3));
				a.setGender(rs.getString(4));
				a.setMeritalStatus(rs.getString(5));
				a.setTypeOfAc(rs.getString(6));
				a.setDOB(rs.getString(7));
				a.setServiseRequired(rs.getString(8));
				a.setAmount(Integer.parseInt(rs.getString(9)));
				a.setPhotoName(rs.getString(10));
				/* list.add(x); */
			}
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
 }
	
	
	public int ModifyData(OpenAccount x) {
		con =DbConnection.getConnection();
		try {
			Statement stmt= con.createStatement();
			String sql ="update AllAccount set Name = '"+x.getName()+"',FatherName='"+x.getFatherName()+"',Gender='"+x.getGender()+"',Merital_status='"+x.getMeritalStatus()+"',TypeOfAcc='"+x.getTypeOfAc()+"',DoB='"+x.getDOB()+"',ServicRequired='"+x.getServiseRequired()+"',Amount="+x.getAmount()+" where AccNo = "+x.getACno()+"";
			
			int status = stmt.executeUpdate(sql);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

}
