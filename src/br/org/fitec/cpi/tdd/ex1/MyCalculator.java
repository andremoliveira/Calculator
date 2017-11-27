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

public class MyCalculator implements Calculator {

	@Override
	public int add(String s) throws NegativeNumberException {
		if (s == null || s.length() == 0) {
			return 0;
		}
		String[] values = s.split(",");
		int sum = 0;
		int num = 0;
		// convert to java8
		StringBuilder builder = new StringBuilder();
		for (String value : values) {
			num = Integer.parseInt(value.trim());
			if (num < 0) {
				builder.append(num + " ");
			} else {
				sum += num;
			}
		}
		if (builder.length() > 0) {
			throw new NegativeNumberException("negatives not allowed: " + builder.toString());
		}
		return sum;
	}

	@Override
	public int subtract(String s) throws NegativeNumberException {

		if (s == null || s.isEmpty())
			return 0;

		String[] values = s.split(",");
		int result = 0;
		int num = 0;

		StringBuilder builder = new StringBuilder();
		for (String value : values) {

			num = Integer.parseInt(value.trim());
			if (num < 0) {
				builder.append(num + " ");
				continue;
			}
			if(num > 1000) {
				continue;
			}

			if (result == 0) {
				result += num;
			} else {
				result -= num;
			}

		}

		if (builder.length() > 0) {
			throw new NegativeNumberException("negatives not allowed: " + builder.toString());
		}
		return result;
	}

	@Override
	public int multiply(String s) throws NegativeNumberException {

		if(s == null || s.isEmpty())
			return 0;
		
		String [] values = s.split(",");
		int result = 1;
		int num = 0;
		
		StringBuilder builder = new StringBuilder();
		for (String value : values) {
			
			num = Integer.parseInt(value.trim());
			if(num < 0) {
				builder.append(num + " ");
				continue;
			}
			
			if(num > 1000) {
				continue;
			}
				
			result *= num;
			
		}
		if (builder.length() > 0) {
			throw new NegativeNumberException("negatives not allowed: " + builder.toString());
		}
		
		return result;
	}

	@Override
	public int divide(String s) throws NegativeNumberException, DivisionByZeroException {

		if(s == null || s.isEmpty())
			return 0;
		
		String [] values = s.split(",");
		int result = 0;
		int num = 0;
		StringBuilder builder = new StringBuilder();
		
		for(String value : values) {
			
			num = Integer.parseInt(value.trim());
			
			if(num < 0) {
				builder.append(num + " ");
				continue;
			}
			
			if(num > 1000) {
				continue;
			}
			
			if(result == 0) {
				result = num;
			} else {
				if(num == 0)
					throw new DivisionByZeroException();
				result /= num;
			}
		}
		
		if (builder.length() > 0) {
			throw new NegativeNumberException("negatives not allowed: " + builder.toString());
		}
		return result;
	}

}
