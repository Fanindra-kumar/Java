package com.pritority_queue;

import java.util.ArrayList;

public class PriorityQueue<T> {
	ArrayList<Element<T>> heap;

	public PriorityQueue() {
		heap = new ArrayList<>();
	}

	public void insert(T data, int priority) {
		Element<T> e = new Element<>(data,priority);
		heap.add(e);
		int index = heap.size()-1;
		int parentIndex = (index-1)/2;
		
		while(index >0){
			if(heap.get(parentIndex).priority > heap.get(index).priority) {
				Element<T> temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(index));
				heap.set(index, temp);
				index = parentIndex;
				parentIndex = (index-1)/2;
			}
			else {
				return;
			}
		}
	}

	public void remove() {

	}
	public T get(T data) {
		return null;
	}
	public int size() {
		return heap.size();	
	}
	public boolean isEmpty() {
		return heap.size()==0;
	}
}
