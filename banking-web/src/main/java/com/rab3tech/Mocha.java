package com.rab3tech;

public class Mocha extends Object {
	
	public MochaService mochaService=new MochaService();
	
	public void setMochaService(MochaService mochaService) {
		this.mochaService = mochaService;
	}


	public int facta(int num) {
		if (num < 0) {
			throw new ArithmeticException("Hey! we can not compute factorial of negative number " + num);
		} else if (num > 10) {
			throw new ArithmeticException("Hey! we can not compute factorial of number greater than " + num);
		}
		int sum=mochaService.cala(num);
		return sum;
	}
}
