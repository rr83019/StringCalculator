package main;

import java.util.Arrays;

public class StringCalculator {

	public Integer Add(String str) {
		if(str.isEmpty()) return 0;
		else {
			String[] numbers = getDelimitedNumbers(str);
			Integer sum = Arrays.stream(numbers).mapToInt(this::toInt).map(num -> checkNegativeNumber(num)).sum();
			return sum;
		}
	}
	
	private String[] getDelimitedNumbers(String str) {
		if(str.startsWith("//")) {
			String[] newStr = str.split("\n");
			String delimiter = newStr[0].split("//")[1];
			return newStr[1].split(delimiter);
		} else {
			return str.split(",|\n");
		}
	}
	
	private int checkNegativeNumber(int number) {
		if(number<0) {
			throw new IllegalArgumentException("negatives not allowed -" + number);
		}
		return number;
	}
		
	private int toInt(String strInt) throws NumberFormatException {
		return Integer.parseInt(strInt);
	}	
	
}
