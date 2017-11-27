package br.org.fitec.cpi.tdd.ex1;

public class DivisionByZeroException extends Exception {

	public DivisionByZeroException()
    {
        super("Division by 0 is not allowed");
    }
}
