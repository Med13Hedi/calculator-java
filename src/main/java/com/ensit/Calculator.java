package com.ensit;

public class Calculator {

	public static double apply(String op, double a, double b) {
		switch (op) {
			case "add": return a + b;
			case "sub": return a - b;
			case "mul": return a * b;
			case "div": return b == 0 ? Double.NaN : a / b;
			default: throw new IllegalArgumentException("Unknown operation: " + op);
		}
	}
}
