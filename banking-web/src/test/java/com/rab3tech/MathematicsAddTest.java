package com.rab3tech;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class MathematicsAddTest {
	
	@Mock
	private MathService mathService;
	
	@InjectMocks
    private 	Mathematics mathematics=new Mathematics();
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
    public void testAddWhenNum1Is4() {
		    //stubbing the mathService magic behavior
    		when(mathService.magic(4,2)).thenReturn(16);
            int result = mathematics.add(4,2);
            assertEquals(21,result);
        	verify(mathService, times(1)).magic(4,2);
        	verifyNoMoreInteractions(mathService);
    }
	
	@Test
    public void testAddWhenNum2Is4() {
		    //stubbing the mathService magic behavior
    		when(mathService.magic(3,4)).thenReturn(17);
            int result = mathematics.add(3,4);
            assertEquals(22,result);
        	verify(mathService, times(1)).magic(3,4);
        	verifyNoMoreInteractions(mathService);
    }
	
	@Test
    public void testAddWhenNum12AndNum2() {
            int result = mathematics.add(2,2);
            assertEquals(4,result);
        	verify(mathService, times(0)).magic(2,2);
    }
	
	@Test
    public void testAddWhenNum1OrNum4Not4() {
            int result = mathematics.add(2,45);
            assertEquals(47,result);
        	verify(mathService, times(0)).magic(2,45);
    }

}
