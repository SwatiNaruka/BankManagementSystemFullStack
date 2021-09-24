package com.bank.Bean;

import java.time.LocalDate;

public class DashBoard {
	private int num;
	private String sDate,eDate;
	private LocalDate a,b;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public LocalDate getA() {
		return a;
	}

	public void setA(LocalDate a) {
		this.a = a;
	}

	public LocalDate getB() {
		return b;
	}

	public void setB(LocalDate b) {
		this.b = b;
	}

	

}
