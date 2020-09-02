package com.rab3tech;

public class MochaService  {
	public int cala(int num) {
		//this is making database call!!!!!!!!!!!!!!!!!!!!!!!!!
		int sum = 1;
		for (int x = 2; x <= num; x++) {
			sum = sum * x;
		}
		return sum;
	}
}
