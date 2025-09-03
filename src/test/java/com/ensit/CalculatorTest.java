package com.ensit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

	@Test
	public void testAdd() {
		assertEquals(5.0, Calculator.apply("add", 2, 3));
	}

	@Test
	public void testAddWithNegativeNumbers() {
		assertEquals(-1.0, Calculator.apply("add", -3, 2));
		assertEquals(-5.0, Calculator.apply("add", -2, -3));
	}

	@Test
	public void testAddWithDecimals() {
		assertEquals(5.5, Calculator.apply("add", 2.5, 3.0), 0.001);
	}

	@Test
	public void testSubtract() {
		assertEquals(2.0, Calculator.apply("sub", 5, 3));
		assertEquals(-1.0, Calculator.apply("sub", 2, 3));
	}

	@Test
	public void testSubtractWithNegativeNumbers() {
		assertEquals(-5.0, Calculator.apply("sub", -3, 2));
		assertEquals(1.0, Calculator.apply("sub", -2, -3));
	}

	@Test
	public void testMultiply() {
		assertEquals(15.0, Calculator.apply("mul", 3, 5));
		assertEquals(0.0, Calculator.apply("mul", 0, 5));
	}

	@Test
	public void testMultiplyWithNegativeNumbers() {
		assertEquals(-15.0, Calculator.apply("mul", -3, 5));
		assertEquals(15.0, Calculator.apply("mul", -3, -5));
	}

	@Test
	public void testMultiplyWithDecimals() {
		assertEquals(7.5, Calculator.apply("mul", 2.5, 3.0), 0.001);
	}

	@Test
	public void testDivide() {
		assertEquals(2.0, Calculator.apply("div", 6, 3));
		assertEquals(2.5, Calculator.apply("div", 5, 2), 0.001);
	}

	@Test
	public void testDivideWithNegativeNumbers() {
		assertEquals(-2.0, Calculator.apply("div", -6, 3));
		assertEquals(2.0, Calculator.apply("div", -6, -3));
	}

	@Test
	public void testDivideByZero() {
		assertTrue(Double.isNaN(Calculator.apply("div", 5, 0)));
		assertTrue(Double.isNaN(Calculator.apply("div", 0, 0)));
	}

	@Test
	public void testDivideZeroByNumber() {
		assertEquals(0.0, Calculator.apply("div", 0, 5));
	}

	@Test
	public void testUnknownOperation() {
		assertThrows(IllegalArgumentException.class, () -> {
			Calculator.apply("mod", 5, 3);
		});
	}

	@Test
	public void testUnknownOperationMessage() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Calculator.apply("pow", 2, 3);
		});
		assertEquals("Unknown operation: pow", exception.getMessage());
	}

	@Test
	public void testCaseSensitiveOperations() {
		assertThrows(IllegalArgumentException.class, () -> {
			Calculator.apply("ADD", 2, 3);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Calculator.apply("Add", 2, 3);
		});
	}

	@Test
	public void testLargeNumbers() {
		assertEquals(2000000.0, Calculator.apply("add", 1000000, 1000000));
		assertEquals(1000000000000.0, Calculator.apply("mul", 1000000, 1000000));
	}

	@Test
	public void testVerySmallNumbers() {
		assertEquals(0.0002, Calculator.apply("add", 0.0001, 0.0001), 0.00001);
		assertEquals(0.00000001, Calculator.apply("mul", 0.0001, 0.0001), 0.000000001);
	}
}
