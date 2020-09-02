package com.rab3tech;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MathematicsTest {
	
	private Mathematics mathematics=null;
	
	@Before
	public void init() {
		 mathematics=new Mathematics();
	}
	
	//Here we are validating method output against input
	@Test
	public void  testFactWhenInputZero() {
		int actual=mathematics.fact(0);
		assertEquals(1, actual);
	}
	
	@Test(expected=ArithmeticException.class)
	public void  testFactWhenInputNegative() {
		mathematics.fact(-10);
	}
	
	@Test
	public void  testFactWhenInputOne() {
		int actual=mathematics.fact(1);
		assertEquals(1, actual);
	}
	
	@Test
	public void  testFactWhenInputFive() {
		int actual=mathematics.fact(5);
		assertEquals(120, actual);
	}
	
	@Test
	public void  testFactWhenInputSeven() {
		int actual=mathematics.fact(7);
		assertEquals(5040, actual);
	}

}


