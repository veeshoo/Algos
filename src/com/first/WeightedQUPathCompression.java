package com.first;

public class WeightedQUPathCompression {

	public int[] id;
	private int[] sz;
	private int[] large;

	public WeightedQUPathCompression(int N) {
		id = new int[N];
		sz = new int[N];
		large = new int[N];
		for(int i=0; i<N; i++) {
			id[i] = i;
			sz[i] = 1;
			large[i] = i;
		}
	}
	
	public int root(int n) {
		while(n != id[n]) {
			id[n] = id[id[n]]; //Path Compression
			n = id[n];
		}
		return n;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if(rootP==rootQ) return;
		
		int largeP = large[p];
		int largeQ = large[q];
		
		if(sz[rootP]>sz[rootQ]) {
			id[rootQ] = rootP;
			sz[rootP] += sz[rootQ];
			if(largeQ > largeP) {
				large[rootP] = largeQ;
			}
			
		} else {
			id[rootP] = rootQ;
			sz[rootQ] += sz[rootP];
			if(largeP > largeQ) {
				large[q] = largeP;
			}
		}
	}
	
	public int findLargest(int n) {
		return large[root(n)];
	}
	
	public static void main(String[] args) {
		WeightedQUPathCompression container = new WeightedQUPathCompression(20);
		int even = 0, odd = 1;
		for(int i=1; i<20; i++) {
			if(i%2==1) {
				container.union(odd, i);
			} else {
				container.union(even, i);
			}
		}
		for(int x=0; x<container.id.length; x++) {
			System.out.println("x["+x+"]: "+container.id[x]);
		}
		System.out.println("The Largest Even is " + container.findLargest(0));
		System.out.println("The Largest Odd is " + container.findLargest(1));
		

	}

}
