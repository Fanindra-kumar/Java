package com.hashMap;

import java.util.ArrayList;

public class Map<K,V> {
	ArrayList<MapNode<K,V>> buckets;
	
	int count;
	int numBucktes;
	
	public Map() {
		this.buckets = new ArrayList<>();
		numBucktes =5;
		for(int i=0; i< numBucktes; i++) {
			buckets.add(null);
		}
	}
	
	private int getIndex(K key) {
		int code = key.hashCode();
		return code % numBucktes;
	}
	
	public void insert(K key, V value) {
		int index = getIndex(key);
		MapNode<K, V> head = buckets.get(index);
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		head = buckets.get(index);
		MapNode<K,V> newHead  = new MapNode<>(key, value);
		newHead.next = head;
		buckets.set(index, newHead);
		count++;
		double loadFactor = 1.0*count/numBucktes;
		if(loadFactor> 0.7) {
			rehash();
		}
		
	}
	private void rehash() {
		// TODO Auto-generated method stub
		ArrayList<MapNode<K,V>> temp = buckets;
		buckets = new ArrayList<>();
		for(int i=0; i< 2*numBucktes; i++) {
			buckets.add(null);
		}
		int count =0;
		numBucktes = numBucktes*2;
		for(int i=0; i< temp.size(); i++) {
			MapNode<K,V> head = temp.get(i);
			while(head != null) {
				insert(head.key, head.value);
				head = head.next;
			}
		}
		
		
		
		
	}

	public V get(K key) {
		int index = getIndex(key);
		MapNode<K,V> head = buckets.get(index);
		while( head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	public V delete(K key) {
		int index = getIndex(key);
		MapNode<K,V> head = buckets.get(index);
		MapNode<K,V> prev = null;
		while(head != null) {
			if(head.key.equals(key)) {
				if(prev != null) {
					prev.next= head.next;
				}
				else {
					buckets.set(index, head.next);
				}
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
}
