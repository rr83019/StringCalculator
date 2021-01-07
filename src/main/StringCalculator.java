package main;

import java.util.Arrays;

public class StringCalculator {

	public Integer Add(String str) {
		if(str.isEmpty()) return 0;
		else if(str.contains(",") || str.contains("\n")){
			String[] numbers = str.split(",|\n");
			Integer sum = Arrays.stream(numbers).mapToInt(this::toInt).sum();
			return sum;
		}
		else return toInt(str);
	}
		
	private int toInt(String strInt) throws NumberFormatException {
		return Integer.parseInt(strInt);
	}	
	
}
