package com.second;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedQueueOfStrings {
	private Node first = null;
	private Node last = null;
	
	private class Node {
		String item;
		Node next;
	}
	
	public void enqueue (String item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(!isEmpty()) {
			oldLast.next = last;
		} else {
			first = last;
		}
	}
	
	public String dequeue () {
		String item = null;
		if(!isEmpty()) {
			item = first.item;
			first = first.next;
		} 
		if(isEmpty()) last = null;
		return item;
	}
	
	public boolean isEmpty() {
		return first==null;
	}

	public static void main(String[] args) {
		LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
		
		while(!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if(s.equals("-")) {
				StdOut.print(queue.dequeue()+" : ");
			} else {
				queue.enqueue(s);
				System.out.println("["+s+"]");
			}
		}
	}

}
