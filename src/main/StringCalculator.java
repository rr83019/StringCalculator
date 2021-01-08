package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
	
	private List<Integer> negativeNumbers = new ArrayList<Integer>();
	private static int calledCount = 0;
	
	private void incrementCount() {
		calledCount++;
	}

	public Integer Add(String str) {
		incrementCount();
		if(str.isEmpty()) return 0;
		else {
			String[] numbers = getDelimitedNumbers(str);
			Integer sum = Arrays.stream(numbers).mapToInt(this::toInt).map(num -> checkNegativeNumber(num)).filter(num -> num <1000).sum();
			if(!negativeNumbers.isEmpty()) {
				throw new IllegalArgumentException("negatives not allowed -" + negativeNumbers);
			}
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
			negativeNumbers.add(number);
		}
		return number;
	}
		
	private int toInt(String strInt) throws NumberFormatException {
		return Integer.parseInt(strInt);
	}
	

	public static int getCalledCount() {
		return calledCount;
	}	
	
}
