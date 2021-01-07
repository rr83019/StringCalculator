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

}
