package com.maxPriority;

import java.util.Arrays;

public class MaxPriority {
	public static void main(String[] args) {
		int[] arr = {8,4,20,15,10,17,16,40,30,35};
		for(int i=0; i< arr.length; i++) {
			built(arr, 0,i);
		}
		System.out.println(Arrays.toString(arr));
		
		for(int i=arr.length-1; i>=0; i--) {
			heapSort(arr, i);
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void built(int[] arr,int start, int index) {
		int parent = (index-1)/2;
		while(parent >=start && arr[parent] < arr[index] ){
			int temp = arr[parent];
			arr[parent] = arr[index];
			arr[index] = temp;
			index = parent;
			parent= (index-1)/2;
		}
	}
	private static void heapSort(int[] arr, int index) {
		int temp = arr[index];
		arr[index] = arr[0];
		arr[0] = temp;
		int i = 0;
		int left = 2*i+1;
		int right = 2*i+2;
		
		while(left <index) {
			int max = i;
			if(arr[i] < arr[left]) {
				max = left;
			}
			if(right < index && arr[max] <arr[right] ) {
				max = right;
			}
			if(max== i) {
				break;
			}
			arr[i] = arr[i]+arr[max];
			arr[max] = arr[i]- arr[max];
			arr[i] = arr[i] - arr[max];
			left = 2*i+1;
			right = 2*i+2;
		}
	}
}
