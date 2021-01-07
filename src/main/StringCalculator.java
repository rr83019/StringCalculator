package main;

public class StringCalculator {

	public Integer Add(String str) {
		if(str.isEmpty()) return 0;
		else if(str.contains(",")){
			String[] numbers = str.split(",");
			return toInt(numbers[0]) + toInt(numbers[1]);
		}
		else return toInt(str);
	}
	
	private static int toInt(String strInt) {
		return Integer.parseInt(strInt);
	}
	
	

}
