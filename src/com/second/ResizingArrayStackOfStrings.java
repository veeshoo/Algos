package com.second;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayStackOfStrings {
	
	private String[] stack = null;
	
	private int pointer = 0;
	
	public ResizingArrayStackOfStrings() {
		stack = new String[1];
	}
	
	public boolean isEmpty() {
		return pointer == 0;
	}
	
	public void push (String item) {
		if(pointer == stack.length) {
			resize(2*stack.length);
		}
		stack[pointer++] = item;
	}

	private void resize(int i) {
		String[] copy = new String[i];
		for(int x=0; x<i; x++) {
			copy[x] = stack[x];
		}
		stack = copy;
	}

	public String pop () {
		String item = stack[--pointer];
		stack[pointer] = null;
		return item;
	}
	
	public static void main(String[] args) {
		ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
		
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
