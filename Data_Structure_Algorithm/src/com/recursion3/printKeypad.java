package com.recursion3;

public class printKeypad {
	
	public static void printKeypad(int input, String soFar) {
		if(input ==0 || input==1) {
			System.out.println(soFar);
			return;
		}
		int digit = input%10;
		String s = getString(digit);
		for(int i=0; i<s.length(); i++) {
			printKeypad(input/10, soFar+s.charAt(i));
		}
	}
	
	private static String getString(int digit) {
		// TODO Auto-generated method stub
		if(digit==2) {
			return "abc";
		}
		if(digit == 3) {
			return "def";
		}
		if(digit == 4) {
			return "ghi";
		}
		if(digit == 5) {
			return "jkl";
		}
		if(digit == 6) {
			return "mno";
		}
		if(digit == 7) {
			return "pqrs";
		}
		if(digit == 8) {
			return "tuv";
		}
		if(digit == 9) {
			return "wxyz";
		}
		else {
			return "";
		}
		
	}

	public static void main(String[] args) {
		printKeypad(23, "");
	}
}
