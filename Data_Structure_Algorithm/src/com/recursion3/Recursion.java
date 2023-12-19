package com.recursion3;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
	public static List<String> subSequences(String s){
		if(s.length()==0) {
			List<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		char c = s.charAt(0);
		List<String> ans = subSequences(s.substring(1));
		List<String> temp = new ArrayList<>();
		for(String str : ans) {
			temp.add(str);
			temp.add(c+str);
		}
		return temp;
	}
	
	
	public static void main(String[] args) {
		List<String> list = subSequences("abc");
		for(String s : list) {
			System.out.println(s);
		}
	}
}
