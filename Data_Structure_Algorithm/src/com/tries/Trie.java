package com.tries;
class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode[] children;
	int childCount;
	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		this.children = new TrieNode[26];
		this.childCount =0;
	}
}
public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode('\0');
	}

	public void add( String word){
		addHelper(root, word);

	}
	private void addHelper(TrieNode root,String data) {
		if(data.length()==0) {
			root.isTerminating = true;
			return;
		}

		int childIndex = data.charAt(0) -'A';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			child = new TrieNode(data.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		addHelper(child, data.substring(1));
	}
	public boolean search(String word) {

		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		// implement this function

		if(root == null){
			return false;
		}

		if(word.length()==0){
			return root.isTerminating;
		}
		int index = word.charAt(0) -'A';
		TrieNode child = root.children[index];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}
	public void remove(String word) {
		remove(root, word);
	}
	private void remove(TrieNode root, String word) {
		
		if(word.length() == 0) {
			root.isTerminating =false;
			return;
		}
		int childIndex = word.charAt(0) -'A';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			return ;
		}
		remove(child, word.substring(1));
		if(child.isTerminating && child.childCount==0) {
			root.childCount--;
			root.children[childIndex] = null;
			
		}
		
	}
}
