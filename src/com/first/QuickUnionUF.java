package com.first;

public class QuickUnionUF {

	private int[] id;

	public QuickUnionUF(int N) {
		id = new int[N];
		int i = 0;
		for(int x : id) {
			x = i++;
		}
	}
	
	public int root(int n) {
		while(n != id[n]) {
			n = id[n];
		}
		return n;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		id[root(p)] = root(q);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
