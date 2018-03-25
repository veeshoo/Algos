package com.second;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedStackOfStrings {
	
	private Node first = null;
	
	private class Node {
		String item;
		Node next;
	}
	
	public void push(String value) {
		Node oldNode = first;
		first = new Node();
		first.item = value;
		first.next = oldNode;
	}
	
	public String pop() {
		String value = first.item;
		first = first.next;
		return value;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public static void main(String[] args) {
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		
		while(!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if(s.equals("-")) {
				StdOut.print(stack.pop()+" : ");
			} else {
				stack.push(s);
				System.out.println("["+s+"]");
			}
		}
	}
}
