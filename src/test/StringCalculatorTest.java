package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.StringCalculator;

class StringCalculatorTest {
	
	private StringCalculator calc = new StringCalculator();
	
	private String toString(Integer... integers) {
		String str = "";
		Random random = new Random();
		List<String> delimiter = Arrays.asList(",", "\n");
		for(Integer ints: integers) {
			str += ints.toString()+delimiter.get(random.nextInt(delimiter.size()));
		}
		return str;
	}

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
		String str = toString(number1, number2);
		assertEquals(number1+number2, calc.Add(str));
	}
	
	@Test
	void multipleNumberArgsTest() {
		Integer number1 = 2, number2 = 5, number3 = 7, number4 = 8;
		Integer sum = number1+number2+number3+number4;
		String str = toString(number1, number2, number3, number4);
		assertEquals(sum,calc.Add(str));
	}
	
	@Test
	void newLineDelimiterTest() {
		Integer number1 = 3, number2 = 5, number3 = 1;
		String str = toString(number1,number2,number3);
		assertEquals(number1+number2+number3, calc.Add(str));
	}
	
	@Test
	void customDelimiterTest() {
		Integer number1 = 2, number2 = 3;
		assertEquals(number1+number2, calc.Add("//;\n"+number1.toString()+";"+number2.toString()));
	}
	
	@Test
	void negativeNumbersArgsTest() {
		Integer number1 = 2, number2 = -10;
		String str = toString(number1,number2);
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			calc.Add(str);
		});

	    String expectedMessage = "negatives not allowed -["+number2.toString()+"]";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void mulitpleNegativeNumbersArgsTest() {
		Integer number1 = -2, number2 = -10;
		String str = toString(number1,number2);
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			calc.Add(str);
		});

	    String expectedMessage = "negatives not allowed -["+number1.toString()+", "+number2.toString()+"]";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void numberGe1000Test() {
		Integer number1 = 2, number2 = 1001;
		String str = toString(number1, number2);
		assertEquals(number1, calc.Add(str));
	}
	
	@Test
	void mulitpleLengthDelimiterTest() {
		Integer number1 = 4, number2 = 8;
		String str = "//[***]\n"+number1.toString()+"***"+number2.toString();
		assertEquals(number1+number2, calc.Add(str));
	}
	
	@Test
	void multipleDelimiterTest() {
		Integer number1 = 2, number2 = 3, number3 = 4;
		String str = "//[*][%]\n"+number1.toString()+"*"+number2.toString()+"%"+number3.toString();
		assertEquals(number1+number2+number3, calc.Add(str));
	}
	
	@Test
	void multipleLengthMultipleDelimiterTest() {
		Integer number1 = 2, number2 = 3, number3 = 5, number4 = 7;
		String str = "//[**][%%%][::::]\n"+number1.toString()+"**"+number2.toString()+"%%%"+number3.toString()+"::::"+number4.toString();
		assertEquals(number1+number2+number3+number4, calc.Add(str));
	}

	@AfterAll
	static void checkAddInvokeTest() {
		assertEquals(12, StringCalculator.getCalledCount());
	}

}
