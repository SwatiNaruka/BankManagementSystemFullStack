package com.bank.service;

public class TransctionServiceIMP implements TransctionService{

	public int deposit(int a, int b) throws ArithmeticException {		
		int sum = a+b;
		return sum;
	}
	
	public int subtract(int withdrawBal, int bal) {
		// TODO Auto-generated method stub
		int subtract = 0;
		if(withdrawBal <= bal) {
			subtract= bal-withdrawBal;
		}
		return subtract;
	}
	
	
}
