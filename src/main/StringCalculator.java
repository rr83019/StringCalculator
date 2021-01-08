package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			Matcher match = Pattern.compile("//(.*)\n(.*)").matcher(str);
			match.matches();
			String delimiter = match.group(1).replaceAll("\\[|\\]","");
			String number = match.group(2);
			return number.split(Pattern.quote(delimiter));
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
