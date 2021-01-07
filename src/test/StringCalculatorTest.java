package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.StringCalculator;

class StringCalculatorTest {
	

	@Test
	void emptyStringTest() {
		StringCalculator calc = new StringCalculator();
		assertEquals(0, calc.Add(""));
	}
	
	@Test
	void oneNumberArgTest() {
		StringCalculator calc = new StringCalculator();
		Integer number = 2;
		assertEquals(number, calc.Add(number.toString()));
	}

}
