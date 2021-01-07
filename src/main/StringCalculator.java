package main;

import java.util.Arrays;

public class StringCalculator {

	public Integer Add(String str) {
		if(str.isEmpty()) return 0;
		else if(str.contains(",")){
			String[] numbers = str.split(",");
			Integer sum = Arrays.stream(numbers).mapToInt(this::toInt).sum();
			return sum;
		}
		else return toInt(str);
	}
	
	private int toInt(String strInt) {
		return Integer.parseInt(strInt);
	}	
	

}
