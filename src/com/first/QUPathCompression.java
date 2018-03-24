package com.first;

public class QUPathCompression {
	
	public int[] id;

	public QUPathCompression(int N) {
		id = new int[N];
		for(int i=0; i<N; i++) {
			id[i] = i;
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
		id[root(p)] = root(q);
	}
	
	public int delete(int p) {
		union(p, p+1);
		return root(p);
	}
	
	public void printStructure() {
		for(int x=0; x<id.length; x++) {
			System.out.print(x+" -> "+id[x]+"\t");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		QUPathCompression store = new QUPathCompression(10);
		store.printStructure();
		
		System.out.println(store.delete(5));
		store.printStructure();
		
		System.out.println(store.delete(4));
		store.printStructure();
		
		System.out.println(store.delete(6));
		store.printStructure();
		
		System.out.println(store.delete(3));
		store.printStructure();
		
		System.out.println(store.delete(7));
		store.printStructure();
		
		System.out.println(store.delete(2));
		store.printStructure();
	}

}
