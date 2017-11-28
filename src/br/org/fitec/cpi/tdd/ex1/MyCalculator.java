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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MyCalculator implements Calculator {

	private static final String NEGATIVE_NOT_ALLOWED = "negatives not allowed: ";
	private static final String SPLITER = ",";
	private static final String SEPARATOR = " ";
	private static final int DECIMAL_PLACES = 1;

	@Override
	public int add(String s) throws NegativeNumberException {

		if (s == null || s.length() == 0) {
			return 0;
		}

		String[] values = s.split(SPLITER);

		this.validateNumbersAllowed(values);

		return Arrays.stream(values).mapToInt(number -> Integer.parseInt(number.trim()))
				.filter(numberAllowed -> numberAllowed < 1001).reduce((a, b) -> a + b).getAsInt();

	}

	@Override
	public int subtract(String s) throws NegativeNumberException {

		if (s == null || s.isEmpty())
			return 0;

		String[] values = s.split(SPLITER);

		this.validateNumbersAllowed(values);

		return Arrays.stream(values).mapToInt(number -> Integer.parseInt(number.trim()))
				.filter(numberAllowed -> numberAllowed < 1001).reduce((a, b) -> a - b).getAsInt();

	}

	@Override
	public double multiply(String s) throws NegativeNumberException {

		if (s == null || s.isEmpty())
			return 0;

		String[] values = s.split(SPLITER);

		this.validateNumbersAllowed(values);

		return Arrays.stream(values).mapToDouble(number -> Integer.parseInt(number.trim()))
				.filter(numberAllowed -> numberAllowed < 1001).reduce((a, b) -> a * b).getAsDouble();

	}

	@Override
	public double divide(String s) throws NegativeNumberException, DivisionByZeroException {

		if (s == null || s.isEmpty())
			return 0;

		String[] values = s.split(SPLITER);

		this.validateNumbersAllowed(values);

		this.validateDivisionByZero(values);

		if (Integer.parseInt(values[0].trim()) == 0)
			return 0;

		Double d = Arrays.stream(values).mapToDouble(number -> Integer.parseInt(number.trim()))
				.filter(numberAllowed -> numberAllowed < 1001).reduce((a, b) -> a / b).getAsDouble();

		return new BigDecimal(d).setScale(DECIMAL_PLACES, RoundingMode.HALF_UP).doubleValue();

	}

	private void validateNumbersAllowed(String[] values) throws NegativeNumberException {

		int[] numbersNotAllowed = Arrays.stream(values).mapToInt(number -> Integer.parseInt(number.trim())).toArray();

		numbersNotAllowed = Arrays.stream(numbersNotAllowed).filter(number -> number < 0).toArray();

		if (numbersNotAllowed.length > 0) {
			throw new NegativeNumberException(NEGATIVE_NOT_ALLOWED + Arrays.stream(numbersNotAllowed)
					.mapToObj(Integer::toString).collect(Collectors.joining(SEPARATOR)));
		}
	}

	private void validateDivisionByZero(String[] values) throws DivisionByZeroException {

		int[] numbersNotAllowed = Arrays.stream(values).mapToInt(number -> Integer.parseInt(number.trim())).toArray();

		numbersNotAllowed = Arrays.stream(numbersNotAllowed).filter(number -> number == 0).toArray();

		if (numbersNotAllowed.length > 0) {
			throw new DivisionByZeroException();
		}
	}
}
