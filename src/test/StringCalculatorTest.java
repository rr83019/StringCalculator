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
	
	@Test
	void twoNumberArgTest() {
		Integer number1 = 2, number2 = 4;
		assertEquals(number1+number2, calc.Add(number1.toString()+","+number2.toString()));
		
	}

}
