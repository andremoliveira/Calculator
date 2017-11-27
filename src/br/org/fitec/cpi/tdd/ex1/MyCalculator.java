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

import java.util.Arrays;
import java.util.stream.Collectors;

public class MyCalculator implements Calculator {

	public static final String NEGATIVE_NOT_ALLOWED = "negatives not allowed: ";
	public static final String SPLITER = ",";
	public static final String SEPARATOR = " ";
	
	@Override
	public int add(String s) throws NegativeNumberException {
		
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		String[] values = s.split(SPLITER);

		int[] numbersNotAllowed = Arrays.stream(values).mapToInt(number -> Integer.parseInt(number.trim())).toArray();

		numbersNotAllowed = Arrays.stream(numbersNotAllowed).filter(number -> number < 0).toArray();

		if (numbersNotAllowed.length > 0) {
			throw new NegativeNumberException(NEGATIVE_NOT_ALLOWED
					+ Arrays.stream(numbersNotAllowed).mapToObj(Integer::toString).collect(Collectors.joining(SEPARATOR)));
		}

		return Arrays.stream(values).filter(numberAllowed -> Integer.parseInt(numberAllowed) >= 0)
				.mapToInt(number -> Integer.parseInt(number.trim()))
				.filter(numberAllowed -> numberAllowed < 1001)
				.sum();

	}

	@Override
	public int subtract(String s) throws NegativeNumberException {

		if (s == null || s.isEmpty())
			return 0;

		String[] values = s.split(SPLITER);

		int[] numbersNotAllowed = Arrays.stream(values).mapToInt(number -> Integer.parseInt(number.trim())).toArray();

		numbersNotAllowed = Arrays.stream(numbersNotAllowed).filter(number -> number < 0).toArray();

		if (numbersNotAllowed.length > 0) {
			throw new NegativeNumberException(NEGATIVE_NOT_ALLOWED
					+ Arrays.stream(numbersNotAllowed).mapToObj(Integer::toString).collect(Collectors.joining(SEPARATOR)));
		}
		
		return Arrays.stream(values).filter(numberAllowed -> Integer.parseInt(numberAllowed.trim()) >= 0)
				.mapToInt(number -> Integer.parseInt(number.trim()))
				.filter(numberAllowed -> numberAllowed < 1001)
				.reduce((a, b) -> a - b)
				.getAsInt();
		
	}

	@Override
	public double multiply(String s) throws NegativeNumberException {

		if (s == null || s.isEmpty())
			return 0;

		String[] values = s.split(",");
		double result = 1;
		int num = 0;

		StringBuilder builder = new StringBuilder();
		for (String value : values) {

			num = Integer.parseInt(value.trim());
			if (num < 0) {
				builder.append(num + " ");
				continue;
			}

			if (num > 1000) {
				continue;
			}

			result *= num;

		}
		if (builder.length() > 0) {
			throw new NegativeNumberException(NEGATIVE_NOT_ALLOWED + builder.toString());
		}

		return result;
	}

	@Override
	public double divide(String s) throws NegativeNumberException, DivisionByZeroException {

		if (s == null || s.isEmpty())
			return 0;

		String[] values = s.split(",");

		if (Integer.parseInt(values[0].trim()) == 0)
			return 0;

		double result = 0.0;
		int num = 0;
		StringBuilder builder = new StringBuilder();

		for (String value : values) {

			num = Integer.parseInt(value.trim());

			if (num < 0) {
				builder.append(num + " ");
				continue;
			}

			if (num > 1000) {
				continue;
			}

			if (result == 0) {
				result = num;
			} else {
				if (num == 0)
					throw new DivisionByZeroException();
				result /= num;
			}
		}

		if (builder.length() > 0) {
			throw new NegativeNumberException(NEGATIVE_NOT_ALLOWED + builder.toString());
		}
		return result;
	}

}
