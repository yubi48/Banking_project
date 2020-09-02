package com.rab3tech;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MochaTest {

	@Mock
	private MochaService mochaService;

	@InjectMocks // Mocha = creating an instance of mocha and injecting MochaService mock object
					// inside
	private Mocha mocha;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = ArithmeticException.class)
	public void testFactaWhenInputNegative() {
		mocha.facta(-10);
		// verify(mochaService, times(0)).cala(-10);
	}

	@Test
	public void testFactaWhenInputZero() {
		when(mochaService.cala(0)).thenReturn(1);
		int result = mocha.facta(0);
		assertEquals(1, result);
		verify(mochaService, times(1)).cala(0);
		verifyNoMoreInteractions(mochaService);
	}

	@Test
	public void testFactaWhenInputOne() {
		when(mochaService.cala(1)).thenReturn(1);
		int result = mocha.facta(1);
		assertEquals(1, result);
		verify(mochaService, times(1)).cala(1);
		verifyNoMoreInteractions(mochaService);
	}

	@Test
	public void testFactaWhenInputFive() {
		when(mochaService.cala(5)).thenReturn(120);
		int result = mocha.facta(5);
		assertEquals(120, result);
		verify(mochaService, times(1)).cala(5);
		verifyNoMoreInteractions(mochaService);
	}

	@Test
	public void testFactaWhenInputSeven() {
		when(mochaService.cala(7)).thenReturn(5040);
		int result = mocha.facta(7);
		assertEquals(5040, result);
		verify(mochaService, times(1)).cala(7);
		verifyNoMoreInteractions(mochaService);

	}

	@Test(expected = ArithmeticException.class)
	public void testFactaWhenInputEleven() {
		mocha.facta(11);
		verifyNoMoreInteractions(mochaService);
	}

	@Ignore
	@Test
	public void testFactaWhenInputEleven223() {

	}

}
