package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;
	
	  @Before
	  public void setUp() throws Exception {
	    ntc = new NewTelephoneCompany();
	  }
	
	@Test(expected = UnsupportedOperationException.class)
	public void invalidStartTime() {
	  ntc.setStartTime(-5);
	  ntc.setDuration(10);
	  ntc.computeCharge();
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void invalidDuration() {
      ntc.setStartTime(1800);
      ntc.setDuration(0);
      ntc.computeCharge();
	}

	
	@Test
	public void bothDiscounts() {
	  double expResult = 1768.0;
      ntc.setStartTime(500);
	  ntc.setDuration(100);
	  assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());	  
	}
	
	@Test
	public void discountedStartTime() {
		double expResult = 1248.0;
		ntc.setStartTime(0);
		ntc.setDuration(60);
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	}
	
	@Test 
	public void discountedDuration() {
		double expResult = 2298.4;
		ntc.setStartTime(800);
		ntc.setDuration(65);
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	}
	
	@Test
	public void noDiscounts() {
		double expResult = 1664.0;
		ntc.setStartTime(1000);
		ntc.setDuration(40);
		assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	}



}
