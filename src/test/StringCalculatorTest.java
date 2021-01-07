package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.StringCalculator;

class StringCalculatorTest {
	
	private StringCalculator calc = new StringCalculator();
	

	@Test
	void emptyStringTest() {
		assertEquals(0, calc.Add(""));
	}
	
	@Test
	void oneNumberArgTest() {
		Integer number = 2;
		assertEquals(number, calc.Add(number.toString()));
	}

}
