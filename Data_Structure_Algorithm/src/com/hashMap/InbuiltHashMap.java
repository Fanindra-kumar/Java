package com.hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InbuiltHashMap {
	
	public static void inbuiltHashMap() {
		Map<String, Integer> map = new HashMap<>();
		// Insert
		map.put("abc", 1);
		map.put("def", 3);
		
		// checking presence
		System.out.println(map.containsKey("abc"));
		
		// size
		System.out.println(map.size());
		
		// get value;
		System.out.println("value of abc : "+map.get("abc"));
		System.out.println("value of def : "+map.get("def"));
		
		// remove
		System.out.println(map.remove("abc"));
	}
	
	
	public static ArrayList<Integer> deleteDuplicate(int[] arr) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int n : arr) {
			if( !map.containsKey(n) ) {
				map.put(n, true);
				ans.add(n);
			}
			
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		inbuiltHashMap();
		int[] arr = {1,2,3,4,5,6,1,2,3,4,5,70};
		ArrayList<Integer> output = deleteDuplicate(arr);
		System.out.println(output);
		

	}

}
