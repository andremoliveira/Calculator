//**********************************************************************
// Copyright (c) 2017 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package br.org.fitec.cpi.tdd.ex1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyCalculatorTest {

	Calculator myCalculator;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myCalculator = new MyCalculator();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		myCalculator = null;
	}

	@Test
	public void testSumTwoNumbersSuccess() throws NegativeNumberException {
		String s = "1,2";
		int result = myCalculator.add(s);
		Assert.assertEquals(3, result);
	}

	@Test
	public void testSumOneNumberSuccess() throws NegativeNumberException {
		String s = "1";
		int result = myCalculator.add(s);
		Assert.assertEquals(1, result);

	}

	@Test
	public void testSumNoNumberSuccess() throws NegativeNumberException {
		String s = "";
		int result = myCalculator.add(s);
		Assert.assertEquals(0, result);

		result = myCalculator.add(null);
		Assert.assertEquals(0, result);
	}

	@Test
	public void testAnyNumberSuccess() throws NegativeNumberException {
		String s = "1,2,3,4,5,6,7,8,9,0";
		int result = myCalculator.add(s);
		Assert.assertEquals(45, result);
	}

	@Test
	public void testNegativeNumberShouldFailException() throws NegativeNumberException {
		String s = "-1";
		try {
			myCalculator.add(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1", msg);
		}
	}

	@Test
	public void testNegativeNumber2ShouldFailException() throws NegativeNumberException {
		String s = "3,-1";
		try {
			myCalculator.add(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1", msg);
		}
	}

	@Test
	public void testNegativeNumber3ShouldFailException() throws NegativeNumberException {
		String s = " -3,-1";
		try {
			myCalculator.add(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -3 -1", msg);
		}
	}

	@Test
	public void testNegativeNumber4ShouldFailException() throws NegativeNumberException {
		String s = "-2, -1";
		try {
			myCalculator.add(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -2 -1", msg);
		}
	}
	
    @Test
    public void testNumberBiggerThan1000ShouldBeIgnored() throws NegativeNumberException
    {
        String s = "2,1001,3";
        int result = myCalculator.add(s);

        Assert.assertEquals(5, result);
    }

	@Test
	public void testSubtractTwoNumbers() throws NegativeNumberException {

		String s = "4,2";
		int result = myCalculator.subtract(s);
		Assert.assertEquals(2, result);
	}

	@Test
	public void testSubtractOneNumber() throws NegativeNumberException {

		String s = "2";
		int result = myCalculator.subtract(s);
		Assert.assertEquals(2, result);
	}

	@Test
	public void testSubtractNoNumber() throws NegativeNumberException {

		String s = "";
		int result = myCalculator.subtract(s);
		Assert.assertEquals(0, result);

		result = myCalculator.subtract(null);
		Assert.assertEquals(0, result);

	}

	@Test
	public void testSubtractNegativeNumberShouldFailException() throws NegativeNumberException {
		String s = "-1";
		try {
			myCalculator.subtract(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1", msg);
		}
	}

	@Test
	public void testSubtractNegativeNumber2ShouldFailException() throws NegativeNumberException {
		String s = "3,-1";
		try {
			myCalculator.subtract(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1", msg);
		}
	}

	@Test
	public void testSubtractNegativeNumber3ShouldFailException() throws NegativeNumberException {
		String s = " -3,-1";
		try {
			myCalculator.subtract(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -3 -1", msg);
		}
	}

	@Test
	public void testSubtractNegativeNumber4ShouldFailException() throws NegativeNumberException {
		String s = "-2, -1";
		try {
			myCalculator.subtract(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -2 -1", msg);
		}
	}

	@Test
	public void testSubtractNumbersBiggerThan1000ShouldBeIgnored() throws NegativeNumberException {

		String s = "6, 1001, 3, 2000, 2";
		int result = myCalculator.subtract(s);
		Assert.assertEquals(1, result);

	}

	@Test
	public void testSubtractCanBeNegativeOrZero() throws NegativeNumberException {

		String s = "6, 8";
		int result = myCalculator.subtract(s);
		Assert.assertEquals(-2, result);

		s = "6,6";
		result = myCalculator.subtract(s);
		Assert.assertEquals(0, result);

	}

	@Test
	public void testMultiplyTwoNumbersSuccess() throws NegativeNumberException {

		String s = "4, 4";
		double result = myCalculator.multiply(s);
		Assert.assertEquals(16, result, 0.01);
	}

	@Test
	public void testMultiplyOneNumberSuccess() throws NegativeNumberException {

		String s = "4";
		double result = myCalculator.multiply(s);
		Assert.assertEquals(4, result, 0.01);
	}

	@Test
	public void testMultiplyNoNumberSuccess() throws NegativeNumberException {

		String s = "";
		double result = myCalculator.multiply(s);
		Assert.assertEquals(0, result, 0.01);

		result = myCalculator.multiply(null);
		Assert.assertEquals(0, result, 0.01);
	}

	@Test
	public void testMultiplyNegativeNumberShouldFailException() throws NegativeNumberException {
		String s = "-1";
		try {
			myCalculator.multiply(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
		}
	}

	@Test
	public void testMultiplyNegativeNumber2ShouldFailException() throws NegativeNumberException {
		String s = "3,-1";
		try {
			myCalculator.multiply(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
		}
	}

	@Test
	public void testMultiplyNegativeNumber3ShouldFailException() throws NegativeNumberException {
		String s = " -3,-1";
		try {
			myCalculator.multiply(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -3 -1 ", msg);
		}
	}

	@Test
	public void testMultiplyNegativeNumber4ShouldFailException() throws NegativeNumberException {
		String s = "-2, -1";
		try {
			myCalculator.multiply(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -2 -1 ", msg);
		}
	}
	
	@Test
	public void testMultiplyNumberBiggerThan1000ShouldBeIgnored() throws NegativeNumberException {
		
		String s = "2, 2000, 3";
		double result = myCalculator.multiply(s);
		Assert.assertEquals(6, result, 0.01);
		
	}
	
	@Test
	public void testDivideTwoNumbersSuccess() throws NegativeNumberException, DivisionByZeroException {
		
		String s = "16,2";
		double result = myCalculator.divide(s);
		Assert.assertEquals(8, result, 0.01);
	}
	
	@Test
	public void testDivideOneNumberSuccess() throws NegativeNumberException, DivisionByZeroException {
		
		String s = "8";
		double result = myCalculator.divide(s);
		Assert.assertEquals(8, result, 0.01);
	}
	
	@Test
	public void testDivideNoNumberSuccess() throws NegativeNumberException, DivisionByZeroException {
		
		String s = "";
		double result = myCalculator.divide(s);
		Assert.assertEquals(0, result, 0.01);
		
		result = myCalculator.divide(null);
		Assert.assertEquals(0, result, 0.01);
	}
	
	@Test
	public void testDivideNegativeNumberShouldFailException() throws NegativeNumberException, DivisionByZeroException {
		String s = "-1";
		try {
			myCalculator.divide(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
		}
	}

	@Test
	public void testDivideNegativeNumber2ShouldFailException() throws NegativeNumberException, DivisionByZeroException {
		String s = "3,-1";
		try {
			myCalculator.divide(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -1 ", msg);
		}
	}

	@Test
	public void testDivideNegativeNumber3ShouldFailException() throws NegativeNumberException, DivisionByZeroException {
		String s = " -3,-1";
		try {
			myCalculator.divide(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -3 -1 ", msg);
		}
	}

	@Test
	public void testDivideNegativeNumber4ShouldFailException() throws NegativeNumberException, DivisionByZeroException {
		String s = "-2, -1";
		try {
			myCalculator.divide(s);
		} catch (NegativeNumberException e) {
			String msg = e.getMessage();
			Assert.assertEquals("negatives not allowed: -2 -1 ", msg);
		}
	}
	
	@Test
	public void testDivideNumberBiggerThan1000ShouldBeIgnored() throws NegativeNumberException, DivisionByZeroException {
		
		String s = "8,2000,2";
		double result = myCalculator.divide(s);
		Assert.assertEquals(4, result, 0.01);
	}
	
	@Test
	public void testDivideByZeroShouldFail() throws DivisionByZeroException, NegativeNumberException {
		String s = "4,0";
		try {
			myCalculator.divide(s);
		} catch (DivisionByZeroException e) {
			String msg = e.getMessage();
			Assert.assertEquals("Division by 0 is not allowed", msg);
		}
	}
	
	@Test
	public void testDivideAnyNumber() throws DivisionByZeroException, NegativeNumberException {
		
		String s = "160, 2, 2, 2 ,2";
		double result = myCalculator.divide(s);
		Assert.assertEquals(10.0, result, 0.01);
	}
	
	@Test
	public void testDivideShouldHaveDecimalNumber() throws NegativeNumberException, DivisionByZeroException {
		
		String s = "5, 2";
		double result = myCalculator.divide(s);
		Assert.assertEquals(2.5, result, 0.01);
		
	}
	
	@Test
	public void testDivideZeroNumeratorShouldBeZero() throws NegativeNumberException, DivisionByZeroException {
		
		String s = "0,2";
		double result = myCalculator.divide(s);
		Assert.assertEquals(0.0, result, 0.01);
	}
}
