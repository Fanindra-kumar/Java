package com.recursion3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubsequence {
	
	public static void printSubquence(String input, String stringSoFar) {
		if(input.length()==0) {
			System.out.println(stringSoFar);
			return;
		}
		printSubquence(input.substring(1), stringSoFar);
		printSubquence(input.substring(1), stringSoFar+input.charAt(0));	
	}
	public static void main(String[] args) {
		
//		printSubquence("abc","");
//		System.out.println(Arrays.toString(permutationOfString("abcd")));
		int[][] ans = subsets(new int[]{15,15,14,7,2,8,3,2});
		for(int[] arr : ans) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static String[] permutationOfString(String input){
		// Write your code here
		List<String> output = permutation(input);
		String[] ans = new String[output.size()];
		for(int i=0; i<output.size(); i++){
			ans[i] = output.get(i);
		}
		return ans;
	}
	private static List<String> permutation(String input){
		if(input.length()==1){
			List<String> output = new ArrayList<String>();
			output.add(input);
			return output;
		}
		List<String> output = permutation(input.substring(1));
		List<String> ans = new ArrayList<>();
		for(String s : output){
			for(int i=0; i<=s.length(); i++){
				StringBuilder sb  = new StringBuilder(s);
				sb.insert(i, input.charAt(0));
				ans.add(sb.toString());
			}
		}
		System.out.println(ans);
		return ans;
	}
	
	
	// Return subset of an array
	public static int[][] subsets(int input[]) {
		// Write your code here
		return subsets(input, 0);
	}
	private static int[][] subsets(int[] input, int s){
		if(s==input.length-1){
			int[][] output = new int[1][];
			int[] ans = new int[1];
			ans[0]  = input[s];
			output[0] = ans;
			
			return output;
		}
	
		int[][] smallOutput  = subsets(input, s+1);
		
		int[][] output = new int[smallOutput.length*2][];
		int index = 0;
		for(int[] ans : smallOutput ){
			output[index++] = ans;
			//System.out.println(Arrays.toString(ans));
		}
		
		for(int i=0; i< smallOutput.length; i++){
			int[] arr = smallOutput[i];
			int size = arr.length;
			int[] temp = new int[size+1];
			for(int j=0; j< arr.length; j++){
				temp[j+1] = smallOutput[i][j];
			}
			//System.out.println(Arrays.toString(temp));
			temp[0] = input[s];
			smallOutput[i] = temp;
			
		}
		
//		for(int[] arr: smallOutput) {
//			int n = arr.length;
//			int[] temp = new int[n+1];
//			temp[0] = input[s];
//			for(int i=0; i< arr.length; i++) {
//				
//			}
//		}
		for(int[] ans : smallOutput ){
			output[index++] = ans;
		}
		
		return output;


	}
	
}
