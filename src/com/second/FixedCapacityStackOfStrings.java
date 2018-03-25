package com.second;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {
	
	private String[] stack;
	
	private int pointer = 0;
	
	public FixedCapacityStackOfStrings(int capacity) {
		stack = new String[capacity];
	}
	
	public boolean isEmpty() {
		return pointer == 0;
	}
	
	public void push (String item) {
		stack[pointer++] = item;
	}
	
	public String pop () {
		String item = stack[--pointer];
		stack[pointer] = null;
		return item;
	}
	
	public static void main(String[] args) {
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
		
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
