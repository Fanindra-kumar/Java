package com.maxPriority;

import java.util.*;

public class MinHeap {
	public static void main(String[] args) {
		
		int[] arr = {23,100,32,1,8,6,9};
		int n = arr.length;
		// building heap
		for(int i = (n/2)-1; i>=0; i--) {
			downHeapify(arr, i, arr.length);
		}
		
		System.out.println(Arrays.toString(arr));
		
		// removing from heap
		for(int i = n-1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			downHeapify(arr, 0, i-1);
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void downHeapify(int[] arr, int index, int end) {
		 int left = 2*index+1;
		 int right= 2*index+2;
		 while(left< end) {
			 int min = index;
			 if(arr[min] > arr[left]) {
				 min = left;
			 }
			 if(right < end && arr[min] >arr[right]) {
				 min = right;
			 }
			 if(min == index) {
				 break;
			 }
			 
			 int temp = arr[min];
			 arr[min] = arr[index];
			 arr[index] = temp;
			 
			 index = left;
			 left= index*2+1;
			 right = index*2+2;
		 }
		 
	}
	
}
